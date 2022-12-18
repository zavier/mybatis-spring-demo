package com.zavier.demo.mbg.model;

import javax.annotation.Generated;

public class TUser {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_name")
    private String userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_age")
    private Integer userAge;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_name")
    public String getUserName() {
        return userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_age")
    public Integer getUserAge() {
        return userAge;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-12-18T10:54:13.447+08:00", comments="Source field: t_user.user_age")
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}