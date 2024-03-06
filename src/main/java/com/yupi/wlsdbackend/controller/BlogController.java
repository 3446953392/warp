package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.wlsdbackend.common.R;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.dto.BlogDto;
import com.yupi.wlsdbackend.service.BlogImgService;
import com.yupi.wlsdbackend.service.BlogService;
import com.yupi.wlsdbackend.service.BlogThumbService;
import com.yupi.wlsdbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;


@RestController
@Slf4j
public class BlogController {
    @Resource
    private BlogService blogService;
    @Resource
    private BlogImgService blogImgService;
    @Resource
    private BlogThumbService blogThumbService;
    @Resource
    private UserService userService;

    @Cacheable(value = "allBlogs")
    @GetMapping("/getAllBlogs")
    public List<BlogDto> getAllBlogs() {
        List<Blog> allBlogs = blogService.list();
        List<BlogDto> blogDtos = new ArrayList<>();

        for (Blog blog : allBlogs) {
            int id = blog.getId();
//            拿到BlogImg
            QueryWrapper<BlogImg> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("blog_id", id);
//            拿到点赞情况和数量
            QueryWrapper<BlogThumb> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("user_id", blog.getUserId()).eq("id", id);
            QueryWrapper<BlogThumb> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("id", id);

            List<BlogImg> blogImg = blogImgService.list(queryWrapper);
            BlogThumb blogThumb = blogThumbService.getOne(queryWrapper2);
            long thumbCount = blogThumbService.count(queryWrapper3);
//            拿到User
            User user = userService.getById(blog.getUserId());

            boolean isThumbed = blogThumb != null;

            BlogDto blogDto = new BlogDto();

            blogDto.setBlog(blog);
            blogDto.setBlogImg(blogImg);
            blogDto.setThumbed(isThumbed);
            blogDto.setThumbCount(thumbCount);
            blogDto.setUser(user);

            blogDtos.add(blogDto);
        }
        return blogDtos;
    }

    @PostMapping("/setBlogThumb")
    public R<BlogThumb> setBlogThumb(@RequestBody BlogThumb blogThumb) {
        blogThumbService.save(blogThumb);
        return R.success(null);
    }

    @PostMapping("/cancelBlogThumb")
    public R<BlogThumb> cancelBlogThumb(@RequestBody BlogThumb blogThumb) {
        QueryWrapper<BlogThumb> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", blogThumb.getUserId()).eq("id", blogThumb.getId());

        blogThumbService.remove(queryWrapper);
        return R.success(null);
    }

}
