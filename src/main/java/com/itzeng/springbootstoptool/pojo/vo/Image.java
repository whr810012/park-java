package com.itzeng.springbootstoptool.pojo.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("图片管理类")
public class Image {

    @ApiModelProperty("图片路径")
    private String url;

    @ApiModelProperty("关联stall表")
    private Integer stallId;
}
