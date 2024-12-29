package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Order;
import com.itzeng.springbootstoptool.pojo.Orderall;

import java.util.List;

public interface OrderService {

    //查询单个订单信息表
    Order getOrder(Integer orderid);

    //查询全部订单信息表
    List<Order> getOrderall();

    //批量删除订单信息
    void deleteOrder(List<Integer> orderid);

    //新增订单表
    void addOrder(Order order);

    //修改订单信息
    void amendOrder(Order order);

    //查看详细订单
    Orderall orderAll(Integer orderid);
}
