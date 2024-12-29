package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.pojo.vo.StallVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StallService {

    //查询单个车位信息表
    List<StallVO> getstall(Integer stallId);

    //查询全部车位信息表
    List<StallVO> getstallall();

    //批量删除车位信息表
    void deleteStall(List<Integer> stallId);

    //新增车位信息
    ResponseEntity<Result> addStall(Stall stall,List<String> image);

    //修改车位信息
    void amendStall(Stall stall);

}
