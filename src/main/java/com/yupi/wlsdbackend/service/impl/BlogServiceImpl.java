package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Blog;
import com.yupi.wlsdbackend.service.BlogService;
import com.yupi.wlsdbackend.mapper.BlogMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【blog(博客表)】的数据库操作Service实现
* @createDate 2024-03-01 14:59:30
*/
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog>
    implements BlogService{

}




