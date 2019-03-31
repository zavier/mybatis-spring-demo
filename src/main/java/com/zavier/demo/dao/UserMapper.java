package com.zavier.demo.dao;

import com.zavier.demo.entity.UserDO;

public interface UserMapper {
    UserDO findById(Integer userId);

    int save(UserDO userDO);
}
