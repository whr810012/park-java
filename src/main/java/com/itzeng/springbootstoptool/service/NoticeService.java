package com.itzeng.springbootstoptool.service;

import com.itzeng.springbootstoptool.pojo.Notice;

import java.util.List;

public interface NoticeService {

    //查询单个公告信息表
    Notice getNotice(Integer noticeId);

    //查询全部公告信息表
    List<Notice> getNoticeall();

    //批量删除公告信息表
    void deleteNotice(List<Integer> noticeId);

    //新增公告
    void addNotice(Notice notice);

    //修改公告信息
    void amendNotice(Notice notice);


}
