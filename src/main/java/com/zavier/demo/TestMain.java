package com.zavier.demo;

import com.zavier.demo.dao.UserDao;
import com.zavier.demo.mapper.UserMapper;
import com.zavier.demo.entity.UserDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        List<UserDO> userDOS = userDao.selectAll();
        System.out.println(userDOS);

        final UserDO userDO = new UserDO();
        userDO.setId(5);
        userDO.setUserName("test");
        userDO.setUserAge(26);
        try {
            userDao.save(userDO, true);
        } catch (Exception e) {
            // ignore
        }

        userDOS = userDao.selectAll();
        System.out.println(userDOS);
    }

}
