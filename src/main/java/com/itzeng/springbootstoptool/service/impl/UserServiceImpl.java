package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.UserMapper;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.User;
import com.itzeng.springbootstoptool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    //注入mapper层接口
    @Autowired
    private UserMapper userMapper;

    //查询单个user用户的信息
    @Override
    public User query(String openId) {
        return userMapper.lookquery(openId);
    }

    //查询全部user用户的信息
    @Override
    public List<User> queryall() {
        return userMapper.lookqueryall();
    }

    //批量删除user用户对象
    @Override
    public void deptsqueryuser(List<String> openId) {
        userMapper.deptById(openId);
    }

    //添加user用户对象
    @Override
    public ResponseEntity<Result> adduser(User user) {
        //user只有openid和时间
        User user1 = userMapper.lookquery(user.getOpenId());
        List<User> lookqueryall = userMapper.lookqueryall();
        for (int i = 0; i < lookqueryall.size(); i++) {
             if (user.getUserName().equals(lookqueryall.get(i).getUserName())) {
                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                         .body(Result.error("该用户名以被占用", 500));
             }
        }

        if (user1 != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Result.error("已有该用户", 500));
        }

        userMapper.adduser(user);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }

    //修改user用户对象
    @Override
    public void amenduser(User user) {
        userMapper.amenduser(user);
    }


    //登录并添加注册时间
    @Override
    public User setQuery(String openId) {
        User user = userMapper.lookquery(openId);
        user.setCreateTime(LocalDateTime.now());
        return userMapper.lookquery(openId);
    }

    //登录openid并注册这个用户
    public void addOpenId(User user1) {
        userMapper.instOpenid(user1);
    }

    //添加用户头像
    public void imageUser(String openId, String upload) {
        //根据openId查询出这个用户
        User lookquery = userMapper.lookquery(openId);
        //给用户的图片路径赋值
        lookquery.setImage(upload);
        //对这个用户进行修改
        userMapper.amenduser(lookquery);
    }

}
