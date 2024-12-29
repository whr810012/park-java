package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.User;
import com.itzeng.springbootstoptool.service.LoginService;
import com.itzeng.springbootstoptool.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@Api(tags = "登录相关接口")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;


    @ApiOperation("登录管理员")
    @PostMapping("/admin/login")
    public ResponseEntity<Result> loginAdmin(@RequestBody Admin admin) {
        log.info("管理员登录验证信息：{}", admin);
        Admin admin1 = loginService.login(admin);
        if (admin1 != null) {
            Map<String, String> claims = new HashMap<>();
            claims.put("email", admin1.getEmail());
            claims.put("password", admin1.getPassword());
            // 返回 200 OK 和成功的 Result
            return ResponseEntity.status(HttpStatus.OK).body(Result.success(admin1));
        }
        // 登录失败，返回 500 错误状态码
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Result.error("邮箱或者密码错误", 500));
    }


    @ApiOperation("登录用户")
    @GetMapping("/user/login")
    public Result loginUser(@RequestParam String openId) {
        log.info("登录用户的openId为：{}", openId);
        User user = userService.query(openId);
        //user有值时则用户存在直接返回用户信息
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(Result.success(user)).getBody();
        } else if (user == null) {   //user无值时则用户不存在创建一个user直接添加进去 添加时间
            User user1 = new User();
            //创建一个空user赋值openid和时间
            user1.setCreateTime(LocalDateTime.now());
            user1.setOpenId(openId);
            userService.addOpenId(user1);
            User query = userService.query(openId);
            return ResponseEntity.status(HttpStatus.OK).body(Result.success(query)).getBody();
        }
        return null;
    }

}
