package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.AdminMapper;
import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    private int j = 0;

    //查询单个管理员
    @Override
    public Admin lookadim(String adminid) {
        return adminMapper.lookadim(adminid);
    }

    //查询全部管理员
    @Override
    public List<Admin> lookadminall() {
        return adminMapper.lookadminall();
    }


    //新增管理员
    @Override
    public ResponseEntity<Result> addadmin(Admin admin) {
        //给管理员设置id用时间戳并转换为正数
        admin.setAdminid(String.valueOf(Math.abs(System.currentTimeMillis())));
        Admin admin1 = adminMapper.lookadim((admin.getAdminid()));
        //判断邮箱adminid是否重复
        List<Admin> adminList = adminMapper.lookadminall();
        for (int i = 0; i < adminList.size(); i++) {
            if (admin.getEmail().equals(adminList.get(i).getEmail())) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Result.error("该邮箱号被占用", 500));
            }
        }
        if (admin1 != null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Result.error("已有该管理员", 500));
        }
        //没有该邮箱和管理员就添加
        adminMapper.addadmin(admin);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }

    //修改管理员
    @Override
    public ResponseEntity<Result> amendadmin(Admin admin) {

        //1.利用Id获取前端传过来这个对象的id
        String adminid = admin.getAdminid();
        //2.利用前端传过来的id查找数据库里面的管理员信息
        Admin admin1 = adminMapper.lookadim(adminid);
        //3.获取这个管理员的Eamil和前端传过来的管理员的Eamil对比，如果一致直接放行，允许添加数据
        //第一种情况只修改别的数据不修改邮箱：判断数据库里面的管理员不是空，并且数据库里面的管理员的邮箱和要修改的邮箱一致，就同意修改
        if (admin1 != null && admin1.getEmail().equals(admin.getEmail())) {
            adminMapper.amendadmin(admin);
            return ResponseEntity.status(HttpStatus.OK).body(Result.success());
        }
        //第二种情况修改邮箱和其他信息：只需判断要修改的邮箱和数据库里面的所有邮箱不一致就行
        List<Admin> adminList = adminMapper.lookadminall();
        for (int i = 0; i < adminList.size(); i++) {
            if (admin.getEmail().equals(adminList.get(i).getEmail())) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Result.error("该邮箱已存在", 500));
            }
        }
        adminMapper.amendadmin(admin);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }


    //批量删除管理员
    @Override
    public void amendadminall(List<String> ids) {
        adminMapper.amendadminall(ids);
    }

}
