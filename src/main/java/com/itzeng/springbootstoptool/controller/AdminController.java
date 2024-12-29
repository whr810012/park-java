package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.BatchDeleteRequest;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "管理员管理项目")
public class AdminController {
    @Autowired
    private AdminService adminService;
    private BatchDeleteRequest batchDeleteRequest;


    @ApiOperation("查询单个管理员")
    @GetMapping("/admin")
    public Result getadmin(@RequestParam String adminid) {
        log.info("查询管理员的adminid为:{}", adminid);
        Admin admin = adminService.lookadim(adminid);
        return Result.success(admin);
    }


    @ApiOperation("查询全部管理员")
    @GetMapping("/adminall")
    public Result getadminall() {
        log.info("查询全部管理员");
        List<Admin> adminList = adminService.lookadminall();
        return Result.success(adminList);
    }

    @ApiOperation("批量删除管理员")
    @PostMapping("/admin/delete")
    public Result deleteadmin(@RequestBody List<String> ids) {
        log.info("删除管理员的adminid为:{}", ids);
        adminService.amendadminall(ids);
        return Result.success();
    }


    @ApiOperation("新增管理员")
    @PostMapping("/admin/add")
    public ResponseEntity<Result> addadmin(@RequestBody Admin admin) {
        log.info("新增管理员的信息为:{}", admin);
        ResponseEntity<Result> addadmin = adminService.addadmin(admin);
        return addadmin;
    }


    @ApiOperation("修改管理员")
    @PostMapping("/admin/amend")
    public ResponseEntity<Result> amendadmin(@RequestBody Admin admin) {
        log.info("修改管理员的信息为:{}", admin);
        ResponseEntity<Result> amendadmin = adminService.amendadmin(admin);
        return amendadmin;
    }

}
