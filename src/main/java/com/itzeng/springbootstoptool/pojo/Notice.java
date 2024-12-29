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
@ApiModel("公告信息实体类")
public class Notice {

    @ApiModelProperty("公告id")
    private Integer noticeId;

    @ApiModelProperty("公告信息")
    private String createName;


    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createTime;


    @ApiModelProperty("公告内容")
    private String content;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    @ApiModelProperty("公告头部")
    private String title;
}
