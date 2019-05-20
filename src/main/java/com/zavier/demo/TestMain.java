package com.zavier.demo;

import com.zavier.demo.dao.UserMapper;
import com.zavier.demo.entity.UserDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        UserMapper userMapper = applicationContext.getBean("userMapper", UserMapper.class);
        List<UserDO> userDOS = userMapper.selectAll();
        System.out.println(userDOS);
    }

}
