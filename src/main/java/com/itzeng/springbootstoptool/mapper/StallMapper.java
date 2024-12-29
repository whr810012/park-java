package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Stall;
import com.itzeng.springbootstoptool.pojo.vo.Image;
import com.itzeng.springbootstoptool.pojo.vo.StallVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StallMapper {

    //查询单个车位信息表
    @Select("select s.*,i.url from stall s left join image i ON s.stall_id = i.stall_id WHERE s.stall_id = #{stallId}")
    List<StallVO> getstall(Integer stallId);

    //查询全部车位信息表
    @Select("select s.*,i.url from stall s left join image i ON s.stall_id = i.stall_id")
    List<StallVO> getstallall();

    //批量删除车位信息表
    void deleteStall(List<Integer> stallId);


    void addStall(Stall stall);

    //修改车位信息
    void amendStall(Stall stall);

    //将全部图片存储在数据库
    void getByImage(List<Image> byimage);

    //批量删除车位的图片所有信息
    void deleteImage(List<Integer> stallId);

    //根据订单表修改其车位的状态
    @Select("select * from stall where stall_id = #{stallId}")
    Stall getOrderStallId(Integer stallId);

    //根据车位id查询车位
    @Select("select * from stall where stall_id = #{stallId}")
    Stall getstalls(Integer stallId);
}
