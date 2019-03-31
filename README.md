# mybatis-spring 的使用示例


使用时需要在mysql数据库中执行文件中的user.sql，并修改spring-mybatis.xml中的连接信息


## MyBatis 基本用法


```java
// 读取MyBatis配置文件
InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
// 从配置文件中构建 SqlSessionFactory (全局只有一个，用于构建 SqlSession)
SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
// 使用 SqlSessionFactory 创建 SqlSession(请求作用域，用后销毁)
SqlSession session = sessionFactory.openSession(true);
// 获取对应 Mapper
UserMapper mapper = session.getUser(UserMapper.class);
// 执行查询
User user = mapper.findById(1);
// 关闭 session
session.close();
```



## mybatis-spring

一、 对于`SqlSessionFactoryBuilder` ，使用`sqlSessionFactoryBean` （实现了Spring的FactoryBean）替代，用来创建 `SqlSessionFactory`

```xml
<!-- 使用SqlSessionFactoryBean 替代 SqlSessionFactoryBuilder -->
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  <!-- 指定数据源 -->
  <property name="dataSource" ref="dataSource" />
  <!-- 使用 mapper 对应的xml文件路径 -->
  <property name="mapperLocations" value="classpath*:sample/config/mappers/**/*.xml" />
  <!-- 还可注入其他属性，如configLocation等 -->
</bean>
```



二、 对于`SqlSession`，提供`SqlSessionTemplate`,  它线程安全（可以简单理解为每次创建新的SqlSession），提供了执行SQL方法，翻译异常功能

```java
// =============================主要源码===========================================
public class SqlSessionTemplate implements SqlSession, DisposableBean {
  private final SqlSessionFactory sqlSessionFactory;
  private final ExecutorType executorType;
  private final SqlSession sqlSessionProxy;
  public SqlSessionTemplate(SqlSessionFactory sqlSessionFactory, ExecutorType executorType, PersistenceExceptionTranslator exceptionTranslator) {
  // SqlSessionInterceptor会拦截，保证获取到新的 sqlSession来执行（线程安全）
  this.sqlSessionProxy = (SqlSession) newProxyInstance(
        SqlSessionFactory.class.getClassLoader(),
        new Class[] { SqlSession.class },
        new SqlSessionInterceptor());
  }
  // 实现了sqlSession的执行操作方法
  @Override
  public <T> T selectOne(String statement) {
    return this.sqlSessionProxy.selectOne(statement);
  }
  // ...
}

private class SqlSessionInterceptor implements InvocationHandler {
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	// 获取sqlSession
    SqlSession sqlSession = getSqlSession(
        SqlSessionTemplate.this.sqlSessionFactory,
        SqlSessionTemplate.this.executorType,
        SqlSessionTemplate.this.exceptionTranslator);
    try {
      Object result = method.invoke(sqlSession, args);
      return result;
    } catch (Throwable t) {
      Throwable unwrapped = unwrapThrowable(t);
	  // 包装处理异常
      throw unwrapped;
    }
  }
}
```

使用（只需注入 SqlSessionFactory）

```xml
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
  <constructor-arg index="0" ref="sqlSessionFactory" />
</bean>
```

之后可以注入此 sqlSession正常使用



三、对于Mapper接口，提供了 MapperFactoryBean（可以为每个mapper声明一个MapperFactoryBean）

SqlSessionDaoSupport

```java
// 主要方法如下，可以实现此类，通过 getSqlSession 方法获取 sqlSessionTemplate 执行
// 通常的实现类是 MapperFactoryBean 
public abstract class SqlSessionDaoSupport extends DaoSupport {
  private SqlSessionTemplate sqlSessionTemplate;

  protected SqlSessionTemplate createSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

  public SqlSession getSqlSession() {
    return this.sqlSessionTemplate;
  }
}
```

MapperFactoryBean

```java
public class MapperFactoryBean<T> extends SqlSessionDaoSupport implements FactoryBean<T> {
  private Class<T> mapperInterface;

  @Override
  public T getObject() throws Exception {
    return getSqlSession().getMapper(this.mapperInterface);
  }
}
```

使用（提供SqlSessionFactory 与要实现的接口）

```xml
<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
  <!-- 指定接口，接口对应的mapper文件需要在sqlSessionFActory中指定 -->
  <property name="mapperInterface" value="org.mybatis.spring.sample.mapper.UserMapper" />
  <property name="sqlSessionFactory" ref="sqlSessionFactory" />
</bean>
```

MapperFactoryBean 是一个 FactoryBean, 它会返回传入的 UserMapper 接口的实例，之后可以使用此方法

```java
public class FooServiceImpl implements FooService {
  private UserMapper userMapper;

  public void setUserMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public User doSomeBusinessStuff(String userId) {
    return this.userMapper.getUser(userId);
  }
}
```



四、使用 MapperScannerConfigurer 简化多个 MapperFactoryBean 声明，可以配置扫码的包，其下的接口会被自动创建成对应的 MapperFactoryBean

```xml
<!-- 扫描路径下的所有接口，自动将它们创建成 MapperFactoryBean -->
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
  <property name="basePackage" value="org.mybatis.spring.sample.mapper" />
</bean>
```

使用时可以直接注入对应的Mapper接口使用

