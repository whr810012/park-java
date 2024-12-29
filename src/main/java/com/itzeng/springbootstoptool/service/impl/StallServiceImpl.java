package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.StallMapper;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.pojo.vo.Image;
import com.itzeng.springbootstoptool.pojo.vo.StallVO;
import com.itzeng.springbootstoptool.service.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StallServiceImpl implements StallService {

    @Autowired
    private StallMapper stallMapper;

    //查询单个车位信息表
    @Override
    public List<StallVO> getstall(Integer stallId) {
        List<StallVO> getstall = stallMapper.getstall(stallId);
        return getstall;
    }

    //查询全部车位信息表
    @Override
    public List<StallVO> getstallall() {
        List<StallVO> getstallall = stallMapper.getstallall();
        return getstallall;
    }

    //批量删除车位信息表
    //事物注解
    @Transactional
    public void deleteStall(List<Integer> stallId) {
        //删除车位的所有信息
        stallMapper.deleteStall(stallId);
        //删除车位的图片所有信息
        stallMapper.deleteImage(stallId);
    }

    //新增车位信息:已优化
    @Override
    public ResponseEntity<Result> addStall(Stall stall,List<String> image) {
        //拿到图片这个集合循环每张图片并赋值同样的stallId在保存在Image表
        List<Image> byimage = new ArrayList<>();
        image.forEach(url ->{
            Image image1 = new Image();
            image1.setStallId(stall.getStallId());
            image1.setUrl(url);
            byimage.add(image1);
        });
        stallMapper.getByImage(byimage);
        stallMapper.addStall(stall);
        return ResponseEntity.status(HttpStatus.OK).body(Result.success());
    }

    //修改车位信息
    @Override
    public void amendStall(Stall stall) {
        stallMapper.amendStall(stall);
    }

}
