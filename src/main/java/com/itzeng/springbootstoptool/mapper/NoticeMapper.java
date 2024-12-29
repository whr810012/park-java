package com.itzeng.springbootstoptool.mapper;

import com.itzeng.springbootstoptool.pojo.Notice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NoticeMapper {

    //查询单个公告信息表
    @Select("select * from notice where noticeId = #{noticeId}")
    Notice getNotice(Integer noticeId);

    //查询全部公告信息表
    @Select("select * from notice")
    List<Notice> getNoticeall();

    //删除公告信息表
    void deleteNotice(List<Integer> noticeId);

    //新增公告
    @Insert("insert into notice(noticeId, createTime, content, createName, endTime, title)"
            + "values (#{noticeId},#{createTime},#{content},#{createName},#{endTime},#{title})")
    void addNotice(Notice notice);

    //修改公告信息
    void amendNotice(Notice notice);


}
