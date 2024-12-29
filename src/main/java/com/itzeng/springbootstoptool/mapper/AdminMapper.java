package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.Result;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Mapper
public interface AdminMapper {

    //查询单个管理员
    @Select("select * from admin where adminid = #{adminid}")
    Admin lookadim(String adminid);

    //查询全部管理员
    @Select("select * from admin")
    List<Admin> lookadminall();

    //新增管理员
    @Insert("insert into admin(email, password, userName, adminid, sorct)" + "values (#{email},#{password},#{userName},#{adminid},#{sorct})")
    void addadmin(Admin admin);

    //修改管理员
    void amendadmin(Admin admin);

    //批量删除管理员
    void amendadminall(List<String> ids);
}
