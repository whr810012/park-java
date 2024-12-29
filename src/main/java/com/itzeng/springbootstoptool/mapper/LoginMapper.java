package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from admin where email = #{email} and password = #{password}")
    Admin login(Admin admin);
}
