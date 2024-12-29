package com.itzeng.springbootstoptool.pojo.vo;

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
@ApiModel("前端接收评价表实体VO")
public class EvaluateVO {

    @ApiModelProperty("用户评价id")
    private Integer evaluateId;

    @ApiModelProperty("用户id")
    private String openId;

    @ApiModelProperty("订单id")
    private Integer orderId;

    @ApiModelProperty("内容")
    private String body;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;

    @ApiModelProperty("评价状态")
    private Integer score;

    @ApiModelProperty("区域id")
    private Integer areaid;


}
