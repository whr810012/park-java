package com.itzeng.springbootstoptool.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户封装类")
public class User {

    @ApiModelProperty("openId")
    private String openId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("手机号")
    private Long phone;

    @ApiModelProperty("图片存储路径")
    private String image;

    @ApiModelProperty("车辆信息")
    private String carInfo;

    @ApiModelProperty("注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;

}
