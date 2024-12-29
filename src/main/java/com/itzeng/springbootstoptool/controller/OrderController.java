package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Order;
import com.itzeng.springbootstoptool.pojo.Orderall;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @ApiOperation("查询单个订单")
    @GetMapping("/order")
    public Result getOrder(@RequestParam Integer orderid) {
        log.info("订单的orderid为:{}", orderid);
        Order order = orderService.getOrder(orderid);
        return Result.success(order);
    }


    @ApiOperation("查询全部订单信息表")
    @GetMapping("/orderall")
    public Result getOrderall() {
        log.info("查询全部订单");
        List<Order> orderall = orderService.getOrderall();
        return Result.success(orderall);
    }


    @ApiOperation("批量删除订单信息")
    @PostMapping("/order/delete")
    public Result deleteOrder(@RequestBody List<Integer> orderid) {
        log.info("删除订单的orderid为:{}", orderid);
        orderService.deleteOrder(orderid);
        return Result.success();
    }


    @ApiOperation("新增订单表")
    @PostMapping("/order/add")
    public Result addOrder(@RequestBody Order order) {
        log.info("新增的订单信息为:{}", order);
        orderService.addOrder(order);
        return Result.success();
    }

    @ApiOperation("修改订单信息")
    @PostMapping("/order/amend")
    public Result amendOrder(@RequestBody Order order) {
        log.info("修改订单的信息为:{}", order);
        orderService.amendOrder(order);
        return Result.success();
    }


    @ApiOperation("查看详情订单")
    @GetMapping("/order/all")
    public Result orderAll(@RequestParam Integer orderid) {
        log.info("查看详细订单的orderid为:{}", orderid);
        Orderall orderall = orderService.orderAll(orderid);
        return Result.success(orderall);
    }


}
