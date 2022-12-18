package com.zavier.demo.mbg;

import com.zavier.demo.mbg.mapper.TUserMapper;
import com.zavier.demo.mbg.model.TUser;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static com.zavier.demo.mbg.mapper.TUserDynamicSqlSupport.id;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

public class MbgMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis-mbg.xml");
        TUserMapper mapper = applicationContext.getBean(TUserMapper.class);

        final List<TUser> tUsers = mapper.select(c -> c.where(id, isEqualTo(100)).limit(100).offset(10));


//        final TUserExampleExt tUserExample = new TUserExampleExt();
//        tUserExample.setLimit(100);
//        tUserExample.setOffset(10);
//        tUserExample.createCriteria()
//                        .andIdBetween(1, 10);
//        final List<TUser> tUsers = mapper.selectByExampleLimit(tUserExample);
        System.out.println(tUsers);
    }
}
