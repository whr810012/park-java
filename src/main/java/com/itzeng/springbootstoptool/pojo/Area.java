package com.itzeng.springbootstoptool.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("车位实体类")
public class Area {

    @ApiModelProperty("车位Id")
    private Integer areaid;

    @ApiModelProperty("车位名称")
    private String areaName;
}
