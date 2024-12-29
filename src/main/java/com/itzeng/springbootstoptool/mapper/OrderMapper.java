package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Order;
import com.itzeng.springbootstoptool.pojo.Orderall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    //查询单个订单信息表
    @Select("select * from orderey where orderid = #{orderid}")
    Order getOrder(Integer orderid);

    //查询全部订单信息表
    @Select("select * from orderey")
    List<Order> getOrderall();

    //批量删除订单信息
    void deleteOrder(List<Integer> orderid);

    //新增订单表
    @Insert("insert into orderey(openId, areaid, stall_id, createTime, status, totalPrice, outTime, startTime, endTime,discount)"
            +"values (#{openId},#{areaid},#{stallId},#{createTime},#{status},#{totalPrice},#{outTime},#{startTime},#{endTime},#{discount})")
    void addOrder(Order order);

    //修改订单信息
    void amendOrder(Order order);

    //查看详细订单
    @Select("select o.*," +
            " u.userName,u.carInfo ," +
            " s.location,s.areaid " +
            "from orderey o JOIN user u ON o.openId = u.openId JOIN stall s ON o.stall_id = s.stall_id where orderid = #{orderid}")
    Orderall orderAll(Integer orderid);
}
