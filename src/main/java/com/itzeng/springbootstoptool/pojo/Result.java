package com.itzeng.springbootstoptool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;  // 响应码，1 代表成功; 0 代表失败
    private String msg;    // 响应信息 描述字符串
    private Object data;   // 返回的数据
    private Integer status; // 新增字段，表示 HTTP 状态码

    // 增删改 成功响应，默认状态码为 200
    public static Result success(){
        return new Result(1, "success", null, 200);
    }

    // 查询 成功响应，返回自定义数据，默认状态码为 200
    public static Result success(Object data){
        return new Result(1, "success", data, 200);
    }

    // 失败响应，返回错误信息，默认状态码为 500
    public static Result error(String msg){
        return new Result(0, msg, null, 500);
    }

    // 失败响应，返回错误信息和自定义 HTTP 状态码
    public static Result error(String msg, int status){
        return new Result(0, msg, null, status);
    }
}
