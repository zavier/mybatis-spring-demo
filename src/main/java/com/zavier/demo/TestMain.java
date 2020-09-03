package com.zavier.demo;

import com.zavier.demo.dao.UserDao;
import com.zavier.demo.entity.UserDO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        List<UserDO> userDOS = userDao.selectAll();
        System.out.println(userDOS);

        for (int i = 0; i < 10; i++) {
            final UserDO userDO = new UserDO();
//            userDO.setUserId(i);
            userDO.setUserName("test");
            userDO.setUserAge(26);

            userDao.save(userDO);
        }

        userDOS = userDao.selectAll();
        System.out.println(userDOS);
        System.out.println(userDOS.size());
    }

}
