package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Area;

import java.util.List;

public interface AreaService {

    //查询区域
    List<Area> lookareaall();

    //批量删除区域
    void areadelete(List<Integer> ids);

    //新增区域
    void areaAdd(Area area);

    //修改区域
    void areaAmend(Area area);
}
