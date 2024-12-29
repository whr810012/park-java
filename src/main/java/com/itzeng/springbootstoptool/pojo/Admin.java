package com.itzeng.springbootstoptool.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员实体类")
public class Admin {

    @ApiModelProperty("管理员邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("adminId")
    private String adminid;

    @ApiModelProperty("管理员级别")
    private Integer sorct;
}
