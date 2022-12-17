package com.zavier.demo.mbg;

import com.zavier.demo.dao.UserDao;
import com.zavier.demo.mbg.mapper.TUserMapper;
import com.zavier.demo.mbg.model.TUser;
import com.zavier.demo.mbg.model.TUserExample;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class MbgMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis-mbg.xml");
        TUserMapper mapper = applicationContext.getBean(TUserMapper.class);

        final TUserExample tUserExample = new TUserExample();
        tUserExample.createCriteria()
                        .andIdBetween(1, 10);
        final List<TUser> tUsers = mapper.selectByExample(tUserExample);
        System.out.println(tUsers);
    }
}
