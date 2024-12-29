package com.itzeng.springbootstoptool.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("订单信息实体类")
public class Order {

    @ApiModelProperty("订单id")
    private Integer orderid;

    @ApiModelProperty("用户id")
    private String openId;

    @ApiModelProperty("车位id")
    private Integer stallId;

    @ApiModelProperty("区域id")
    private Integer areaid;

    @ApiModelProperty("订单创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("订单状态")
    private Integer status;

    @ApiModelProperty("订单价格")
    private double totalPrice;

    @ApiModelProperty("主动离场时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime outTime;

    @ApiModelProperty("订单预定的开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @ApiModelProperty("订单结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("折扣")
    private double discount;

}
