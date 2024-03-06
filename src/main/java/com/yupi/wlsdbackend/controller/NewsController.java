package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.dto.MeetingDto;
import com.yupi.wlsdbackend.service.MediaVideoService;
import com.yupi.wlsdbackend.service.NewsDetailService;
import com.yupi.wlsdbackend.service.NewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class NewsController {
    @Resource
    private NewsService newsService;
    @Resource
    private NewsDetailService newsDetailService;

    @GetMapping("/getAllNews")
    public List<News> getAllNews() {
        return newsService.list();
    }

    @GetMapping("/getNewsById")
    public News getNewsById(@RequestParam("news_id") int news_id) {

        return newsService.getById(news_id);
    }

    @GetMapping("/getNewsDetail")
    public NewsDetail getNewsDetail(@RequestParam("news_id") int news_id) {
        QueryWrapper<NewsDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("news_id", news_id);

        return newsDetailService.getOne(queryWrapper);
    }
}
