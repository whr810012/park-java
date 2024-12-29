package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Evaluate;
import com.itzeng.springbootstoptool.pojo.vo.EvaluateVO;

import java.util.List;

public interface EvaluateService {

    //查询单个用户评价表
    Evaluate getEvaluate(Integer evaluateId);

    //查询全部用户评价表
    List<EvaluateVO> getEvaluateall();

    //批量删除用户评价表
    void deleteEvaluate(List<Integer> evaluateId);

    //新增用户评价表
    void addEvaluate(Evaluate evaluate);

    //修改用户评价表
    void amendEvaluate(Evaluate evaluate);







}
