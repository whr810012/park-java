package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    //查询单个user用户的信息
    User query(String openId);

    //查询全部user用户的信息
    List<User> queryall();

    //删除user用户对象
    void deptsqueryuser(List<String> openId);

    //添加user用户对象
    ResponseEntity<Result> adduser(User user);

    //修改user用户对象
    void amenduser(User user);

    //登录并传时间
    User setQuery(String openId);

    //登录
    void addOpenId(User user1);

    //添加用户头像
    void imageUser(String openId, String upload);
}
