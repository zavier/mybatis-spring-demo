package com.zavier.demo.dao;

import com.zavier.demo.entity.UserDO;
import com.zavier.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<UserDO> selectAll() {
        final List<UserDO> userDOS = userMapper.selectAll();
        return userDOS;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(UserDO userDO, boolean exp) {
        final int save = userMapper.save(userDO);
        if (exp) {
            throw new RuntimeException("rollback...");
        }
    }
}
