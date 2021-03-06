package com.zavier.demo.mapper;

import com.zavier.demo.entity.UserDO;

import java.util.List;

public interface UserMapper {
    UserDO findById(Integer userId);

    List<UserDO> selectAll();

    int save(UserDO userDO);
}
