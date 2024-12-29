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
@ApiModel("管理员登录验证实体类")
public class Person {

        @ApiModelProperty("管理员邮箱")
        private String email;

        @ApiModelProperty("管理员密码")
        private String password;

        // Getter 和 Setter
}
