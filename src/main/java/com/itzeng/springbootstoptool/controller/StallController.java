package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.pojo.vo.StallVO;
import com.itzeng.springbootstoptool.service.StallService;
import com.itzeng.springbootstoptool.utils.AliOSSUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
//@RestController("/stall")
@RestController
@Api(tags = "车位信息相关接口")
public class StallController {
    @Autowired
    private StallService stallService;
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @ApiOperation("查询单个车位表")
    @GetMapping("/stall")
    public Result getstAll(@RequestParam Integer stallId) {
        log.info("查询的车位表stall_id为:{}", stallId);
        List<StallVO> getstall = stallService.getstall(stallId);
        return Result.success(getstall);
    }


    @ApiOperation("查询全部车位信息表")
    @GetMapping("/stallall")
    public Result getstallAll() {
        log.info("查询全部车位表");
        List<StallVO> list = stallService.getstallall();
        return Result.success(list);
    }


    @ApiOperation("批量删除车位信息表")
    @PostMapping("/stall/delete")
    public Result deleteStall(@RequestBody List<Integer> stallId) {
        log.info("批量删除车位的stall_id为:{}", stallId);
        stallService.deleteStall(stallId);
        return Result.success();
    }


    @ApiOperation("新增车位信息")
    @PostMapping("/stall/add")
    public ResponseEntity<Result> addStall(Stall stall,@RequestParam("images") MultipartFile[] files) throws IOException {
        log.info("新增车位的信息为:{}", stall);
        List<String> image = new ArrayList<>();
        for (MultipartFile file : files) {
            String url = aliOSSUtils.upload(file);  // 上传文件并获取 URL
            image.add(url);
        }
        ResponseEntity<Result> entity = stallService.addStall(stall,image);
        return entity;
    }


    @ApiOperation("修改车位信息")
    @PostMapping("/stall/amend")
    public Result amendStall(@RequestBody Stall stall) {
        log.info("修改车位的信息为:{}", stall);
        stallService.amendStall(stall);
        return Result.success();
    }


}
