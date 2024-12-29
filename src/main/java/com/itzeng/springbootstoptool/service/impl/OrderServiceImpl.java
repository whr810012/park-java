package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.OrderMapper;
import com.itzeng.springbootstoptool.mapper.StallMapper;
import com.itzeng.springbootstoptool.pojo.Order;
import com.itzeng.springbootstoptool.pojo.Orderall;
import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.pojo.vo.StallVO;
import com.itzeng.springbootstoptool.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StallMapper stallMapper;

    //查询单个订单信息表
    @Override
    public Order getOrder(Integer orderid) {
        return orderMapper.getOrder(orderid);
    }

    //查询全部订单信息表
    @Override
    public List<Order> getOrderall() {
        List<Order> orderall = orderMapper.getOrderall();
        orderall.forEach(order -> {
            LocalDateTime startTime = order.getStartTime();
            //订单超时
            //订单结束时间
            LocalDateTime endTime = order.getEndTime();

            Duration duration = Duration.between(endTime, LocalDateTime.now());
            Duration durations = Duration.between(startTime, LocalDateTime.now());
            // 获取时间差的秒数-超时
            long seconds = duration.getSeconds();
            long seconds1 = durations.getSeconds();
//            获取订单状态
            Integer status = order.getStatus();
            //大于0则超时
            if (seconds > 0 && status == 1) {
                //订单超时改变status状态
                order.setStatus(2);
                orderMapper.amendOrder(order);
            }
            if (seconds1 > 0 && status == 0) {
                order.setStatus(1);
                Stall getstalls = stallMapper.getstalls(order.getStallId());
                getstalls.setStatus(2);
                stallMapper.amendStall(getstalls);
                orderMapper.amendOrder(order);
            }
        });


        return orderall;
    }

    //批量删除订单信息
    @Override
    public void deleteOrder(List<Integer> orderid) {
        orderMapper.deleteOrder(orderid);
    }

    //新增订单表
    @Override
    public void addOrder(Order order) {
        //赋值折扣
        order.setDiscount(1);
        //新增订单的同时进入车位表修改其状态
        Integer stallId = order.getStallId();
        //车位表拿到反值
        Stall orderStallId = stallMapper.getOrderStallId(stallId);
        //判断订单的状态来改变车位的状态
        if (order.getStatus() == 0) {
            orderStallId.setStatus(1);
        } else if (order.getStatus() == 1) {
            orderStallId.setStatus(2);
        }
        //修改车位状态的信息
        stallMapper.amendStall(orderStallId);

        orderMapper.addOrder(order);
    }

    //修改订单信息
    @Transactional
    public void amendOrder(Order order) {
        Integer stallId = order.getStallId();
        Stall stall = stallMapper.getstalls(stallId);
        if (order.getStatus() == 3) {
            stall.setStatus(0);
            stallMapper.amendStall(stall);
        }
        orderMapper.amendOrder(order);
    }

    //查看详细订单
    @Override
    public Orderall orderAll(Integer orderid) {
        return orderMapper.orderAll(orderid);
    }
}

