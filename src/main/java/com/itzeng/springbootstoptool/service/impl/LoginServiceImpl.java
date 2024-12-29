package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.AdminMapper;
import com.itzeng.springbootstoptool.mapper.LoginMapper;
import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    //登录管理员
    @Override
    public Admin login(Admin admin) {
        return loginMapper.login(admin);
    }
}
