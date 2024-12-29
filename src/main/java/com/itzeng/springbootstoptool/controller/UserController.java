package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.User;
import com.itzeng.springbootstoptool.service.UserService;
import com.itzeng.springbootstoptool.utils.AliOSSUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "用户相关接口")
public class UserController {
    //注入been对象
    @Autowired
    private UserService userService;
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @ApiOperation("查询单个用户")
    @GetMapping("/queryuser")
    public Result getuser(@RequestParam String openId) {
        log.info("查询单个user用户的id为:{}", openId);
        User user = userService.query(openId);
        return user != null ? Result.success(user) : Result.error("该用户不存在");
    }


    @ApiOperation("查询全部用户")
    @GetMapping("/queryuserall")
    public Result getuserall() {
        log.info("查询全部user用户");
        List<User> user = userService.queryall();
        return Result.success(user);
    }


    @ApiOperation("批量删除用户")
    @PostMapping("/user/detele")
    public Result deptsqueryuser(@RequestBody List<String> openId) {
        log.info("批量删除id为{}的用户", openId);
        userService.deptsqueryuser(openId);
        return Result.success();
    }


    @ApiOperation("添加用户")
    @PostMapping("/user/add")
    public ResponseEntity<Result> adduser(@RequestBody User user) {
        log.info("添加用户的信息：{}", user);
        ResponseEntity<Result> adduser = userService.adduser(user);
        return adduser;
    }


    @ApiOperation("修改用户")
    @PostMapping("/user/amend")
    public Result amenduser(@RequestBody User user) {
        log.info("修改更新的用户信息为{}", user);
        userService.amenduser(user);
        return Result.success();
    }

    @ApiOperation("添加用户头像")
    @PostMapping("/user/image")
    public Result imageUser(String openId, MultipartFile image) throws IOException {
        log.info("添加用户头像的openId为{}，头像路径为{}", openId,image);
        String upload = aliOSSUtils.upload(image);
        userService.imageUser( openId,upload);
        return Result.success(upload);
    }





}
