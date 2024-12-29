package com.itzeng.springbootstoptool.controller;

import com.itzeng.springbootstoptool.pojo.Notice;
import com.itzeng.springbootstoptool.pojo.Order;
import com.itzeng.springbootstoptool.pojo.Result;
import com.itzeng.springbootstoptool.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Api(tags = "公告信息相关接口")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;


    @ApiOperation("查询单个公告信息表")
    @GetMapping("/notice")
    public Result getNotice(@RequestParam Integer noticeId) {
        log.info("查询单个公告信息的noticeId为：{}", noticeId);
        Notice notice = noticeService.getNotice(noticeId);
        return Result.success(notice);
    }


    @ApiOperation("查询全部公告信息表")
    @GetMapping("/noticeall")
    public Result getNoticeall() {
        log.info("查询全部公告信息");
        List<Notice> notice = noticeService.getNoticeall();
        return Result.success(notice);
    }


    @ApiOperation("批量删除公告信息表")
    @PostMapping("/notice/delete")
    public Result deleteNotice(@RequestBody List<Integer> noticeId) {
        log.info("批量删除公告信息的noticeId为：{}", noticeId);
        noticeService.deleteNotice(noticeId);
        return Result.success();
    }


    @ApiOperation("新增公告信息")
    @PostMapping("/notice/add")
    public Result addNotice(@RequestBody Notice notice) {
        log.info("新增的公告信息为：{}", notice);
        Notice newnotice = noticeService.getNotice(notice.getNoticeId());
        if (newnotice != null) {
            return Result.error("已有该公告信息");
        } else {
            noticeService.addNotice(notice);
            return Result.success();
        }
    }


    @ApiOperation("修改公告信息")
    @PostMapping("/notice/amend")
    public Result amendNotice(@RequestBody Notice notice) {
        log.info("修改的公告信息为：{}", notice);
        noticeService.amendNotice(notice);
        return Result.success();
    }
}
