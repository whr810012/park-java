package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.EvaluateMapper;
import com.itzeng.springbootstoptool.pojo.Evaluate;
import com.itzeng.springbootstoptool.pojo.vo.EvaluateVO;
import com.itzeng.springbootstoptool.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    EvaluateMapper evaluateMapper;

    //查询单个用户评价表
    @Override
    public Evaluate getEvaluate(Integer evaluateId) {
       return evaluateMapper.getEvaluate(evaluateId);
    }

    //查询全部用户评价表
    @Override
    public List<EvaluateVO> getEvaluateall() {
      return  evaluateMapper.getEvaluateall();
    }

    //批量删除用户评价表
    @Override
    public void deleteEvaluate(List<Integer> evaluateId) {
        evaluateMapper.deleteEvaluate(evaluateId);
    }

    //新增用户评价表
    @Override
    public void addEvaluate(Evaluate evaluate) { evaluateMapper.addEvaluate(evaluate);}

    //修改用户评价表
    @Override
    public void amendEvaluate(Evaluate evaluate) {
        evaluateMapper.amendEvaluate(evaluate);
    }


}
