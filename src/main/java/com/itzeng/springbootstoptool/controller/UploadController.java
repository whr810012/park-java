package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.service.StallService;
import com.itzeng.springbootstoptool.utils.AliOSSUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@Api(tags = "图片上传相关接口")
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    //本地存储文件的方式这个我没写完，如果你是想本地存储的话就继续往下写
//    @PostMapping("/upload")
//    public Result upload(String username ,Integer age, MultipartFile image) {
//        log.info("文件上传，{}，{}，{}",username,age,image);
//        return Result.success();
//    }
    //注卖家用图片需改oss云

    @ApiOperation("图片上传接口")
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传,{}", image.getOriginalFilename());
        //调用阿里云OSS工具类来进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成,文件url访问的路径是{}", url);
        return Result.success(url);
    }
    @PostMapping("/images")
    public Result uploadImages(MultipartFile[] images) throws IOException {
        List<String> fileUrls = new ArrayList<>();
            for (MultipartFile file : images) {
                String url = aliOSSUtils.upload(file);  // 上传文件并获取 URL
                fileUrls.add(url); //添加进集合里返回给数据库

               //根据id找到这个车位把这个属性添加到车位表里
            }
        return Result.success(fileUrls);  // 返回所有上传文件的 URL 列表
    }



}
