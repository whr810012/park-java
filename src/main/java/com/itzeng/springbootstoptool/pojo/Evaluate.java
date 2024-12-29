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
@ApiModel("用户评价实体类")
public class Evaluate {

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
}
