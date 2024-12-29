package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Evaluate;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.vo.EvaluateVO;
import com.itzeng.springbootstoptool.service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "用户评价相关接口")
public class EvaluateController {

    @Autowired
    private EvaluateService evaluateService;


    @ApiOperation("查看单个用户评价")
    @GetMapping("/evaluate")
    public Result getEvaluate(@RequestParam Integer evaluateId) {
        log.info("查询单个用户评价的evaluateId为{}", evaluateId);
        Evaluate evaluate = evaluateService.getEvaluate(evaluateId);
        return Result.success(evaluate);
    }


    @ApiOperation("查询全部用户评价表")
    @GetMapping("/evaluateall")
    public Result getEvaluateall() {
        log.info("查询全部用户评价表");
        List<EvaluateVO> evaluateall = evaluateService.getEvaluateall();
        return Result.success(evaluateall);
    }


    @ApiOperation("批量删除用户评价")
    @PostMapping("/evaluate/delete")
    public Result deleteEvaluate(@RequestBody List<Integer> evaluateId) {
        log.info("删除用户评价信息的evaluateId为{}", evaluateId);
        evaluateService.deleteEvaluate(evaluateId);
        return Result.success();
    }


    @ApiOperation("新增用户评价")
    @PostMapping("/evaluate/add")
    public Result addEvaluate(@RequestBody Evaluate evaluate) {
        log.info("新增用户评价的信息为{}", evaluate);
        evaluateService.addEvaluate(evaluate);
        return Result.success();
    }


    @ApiOperation("修改用户评价")
    @PostMapping("/evaluate/amend")
    public Result amendEvaluate(@RequestBody Evaluate evaluate) {
        log.info("修改用户评价的信息为{}", evaluate);
        evaluateService.amendEvaluate(evaluate);
        return Result.success();
    }

}
