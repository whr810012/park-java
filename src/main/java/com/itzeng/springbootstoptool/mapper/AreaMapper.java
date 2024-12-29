package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Admin;
import com.itzeng.springbootstoptool.pojo.Area;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper {

    //查询全部区域
    @Select("select * from area")
    List<Area> lookareaall();

    //批量删除区域
    void areadelete(List<Integer> ids);

    //新增区域
    @Insert("insert into area(areaid, areaName) VALUES (#{areaid},#{areaName})")
    void areaAdd(Area area);

    //修改区域
    void areaAmend(Area area);



}
