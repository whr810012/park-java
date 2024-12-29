package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.AreaMapper;
import com.itzeng.springbootstoptool.pojo.Area;
import com.itzeng.springbootstoptool.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;


    //查询全部区域
    public List<Area> lookareaall() {
        return areaMapper.lookareaall();
    }

    //批量删除区域
    public void areadelete(List<Integer> ids) {
        areaMapper.areadelete(ids);
    }

    //新增区域
    public void areaAdd(Area area) {
        areaMapper.areaAdd(area);
    }

    //修改区域
    public void areaAmend(Area area) {
        areaMapper.areaAmend(area);
    }


}
