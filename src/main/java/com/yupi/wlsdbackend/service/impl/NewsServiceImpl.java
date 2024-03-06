package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.News;
import com.yupi.wlsdbackend.service.NewsService;
import com.yupi.wlsdbackend.mapper.NewsMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【news(新闻资讯)】的数据库操作Service实现
* @createDate 2024-02-26 12:31:28
*/
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
    implements NewsService{

}




