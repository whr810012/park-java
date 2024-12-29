package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Area;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "车位相关接口")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ApiOperation("查询全部区域")
    @GetMapping("/areaAll")
    public Result getareaall() {
        log.info("查询所有区域");
        List<Area> areaList = areaService.lookareaall();
        return Result.success(areaList);
    }

    @ApiOperation("批量删除区域")
    @PostMapping("/area/delete")
    public Result areadelete(@RequestBody  List<Integer> ids) {
        log.info("批量删除区域");
        areaService.areadelete(ids);
        return Result.success();
    }

    @ApiOperation("新增区域")
    @PostMapping("/area/add")
    public Result areaAdd(@RequestBody  Area area) {
        log.info("新增区域");
        areaService.areaAdd(area);
        return Result.success();
    }

    @ApiOperation("修改区域")
    @PostMapping("/area/amend")
    public Result areaAmend(@RequestBody  Area area) {
        log.info("修改区域");
        areaService.areaAmend(area);
        return Result.success();
    }













}
