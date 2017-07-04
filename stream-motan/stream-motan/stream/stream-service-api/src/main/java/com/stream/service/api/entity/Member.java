package com.stream.service.api.entity;

import java.io.Serializable;

/**
 * 会员信息
 * @author laizs
 * @time 2016年4月8日上午11:09:19
 * @file Member.java
 */
public class Member implements Serializable{
    private String id;
    private String username;
    private String password;
    private String sex;
    private String email;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "Member [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", email="
                + email + "]";
    }


}