package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Evaluate;
import com.itzeng.springbootstoptool.pojo.vo.EvaluateVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvaluateMapper {
    //查询单个用户评价表
    @Select("select * from evaluate where evaluateId = #{evaluateId}")
    Evaluate getEvaluate(Integer evaluateId);

    //查询全部用户评价表:（车位信息，stall表的location，areaId）location没实现
    @Select("select e.*,o.areaid from evaluate e left join orderey o ON e.orderId = o.orderid ")
    List<EvaluateVO> getEvaluateall();

    //批量删除用户评价表
    void deleteEvaluate(List<Integer> evaluateId);

    //新增用户评价表
    @Insert("insert into evaluate(openId, orderId, body, createTime, score)"+"values (#{openId},#{orderId},#{body},#{createTime},#{score})")
    void addEvaluate(Evaluate evaluate);

    //修改用户评价表
    void amendEvaluate(Evaluate evaluate);
}
