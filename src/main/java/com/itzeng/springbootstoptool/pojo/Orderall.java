package com.itzeng.springbootstoptool.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Api("订单相关多表查询")
public class Orderall {

    @ApiModelProperty("订单id")
    private Integer orderid;

    @ApiModelProperty("用户id")
    private String openId;

    @ApiModelProperty("车位id")
    private Integer stallId;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("订单状态")
    private Integer status;

    @ApiModelProperty("订单价格")
    private double totalPrice;

    @ApiModelProperty("主动离场时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime outTime;

    @ApiModelProperty("订单开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty("订单结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("车辆信息")
    private String carInfo;

    @ApiModelProperty("区域")
    private String location;

    @ApiModelProperty("区域Id")
    private Integer areaid;

    @ApiModelProperty("折扣")
    private double discount;

}
