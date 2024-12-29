package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询单个user用户的信息
    @Select("select * from user where openId = #{openId}")
    User lookquery(String openId);

    //查询全部user用户的信息
    @Select("select * from user")
    List<User> lookqueryall();

    //批量删除用户
    void deptById(List<String> openId);

    //添加user用户对象
    @Insert("insert into user(openId,userName,age,phone,image)" + "values (#{openId},#{userName},#{age},#{phone},#{image})")
    void adduser(User user);

    //修改user用户对象
    void amenduser(User user);

    //登录并注册
    @Insert("insert into user(openId, createTime) values (#{openId},#{createTime})")
    void instOpenid(User user1);

}
