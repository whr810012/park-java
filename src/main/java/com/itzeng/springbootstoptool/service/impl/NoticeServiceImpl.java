package com.itzeng.springbootstoptool.service.impl;

import com.itzeng.springbootstoptool.mapper.NoticeMapper;
import com.itzeng.springbootstoptool.pojo.Notice;
import com.itzeng.springbootstoptool.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    //查询单个公告信息表
    @Override
    public Notice getNotice(Integer noticeId) {
        return noticeMapper.getNotice(noticeId);
    }

    //查询全部公告信息表
    @Override
    public List<Notice> getNoticeall() {
        return noticeMapper.getNoticeall();
    }

    //批量删除公告信息表
    @Override
    public void deleteNotice(List<Integer> noticeId) {
        noticeMapper.deleteNotice(noticeId);
    }

    //新增公告
    @Override
    public void addNotice(Notice notice) {
        noticeMapper.addNotice(notice);
    }

    //修改公告信息
    @Override
    public void amendNotice(Notice notice) {
        noticeMapper.amendNotice(notice);
    }


}
