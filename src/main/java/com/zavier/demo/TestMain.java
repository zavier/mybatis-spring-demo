package com.zavier.demo;

import com.zavier.demo.dao.UserMapper;
import com.zavier.demo.entity.UserDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        UserMapper userMapper = applicationContext.getBean("userMapper", UserMapper.class);

        UserDO userDO = new UserDO();
        userDO.setUserName("testname");
        userDO.setUserAge(1);
        userMapper.save(userDO);

        userDO = userMapper.findById(1);
        System.out.println(userDO);
    }

}
