package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.Result;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    //查询单个管理员
    Admin lookadim(String adminid);

    //查询全部管理员
    List<Admin> lookadminall();

    //新增管理员
    ResponseEntity<Result> addadmin(Admin admin);

    //修改管理员
    ResponseEntity<Result> amendadmin(Admin admin);

    //批量删除管理员
    void amendadminall(List<String> ids);
}
