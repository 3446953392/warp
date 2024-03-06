package com.yupi.wlsdbackend.dto;

import com.yupi.wlsdbackend.domain.Blog;
import com.yupi.wlsdbackend.domain.BlogImg;
import com.yupi.wlsdbackend.domain.User;

import java.util.List;

public class BlogDto {
    private Blog blog;
    private List<BlogImg> blogImg;
    private boolean isThumbed;
    private long thumbCount;
    private User user;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<BlogImg> getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(List<BlogImg> blogImg) {
        this.blogImg = blogImg;
    }

    public boolean isThumbed() {
        return isThumbed;
    }

    public void setThumbed(boolean thumbed) {
        isThumbed = thumbed;
    }

    public long getThumbCount() {
        return thumbCount;
    }

    public void setThumbCount(long thumbCount) {
        this.thumbCount = thumbCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}