package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.BlogThumb;
import com.yupi.wlsdbackend.domain.MeetingDetail;
import com.yupi.wlsdbackend.mapper.BlogThumbMapper;
import com.yupi.wlsdbackend.service.BlogThumbService;
import com.yupi.wlsdbackend.service.MeetingDetailService;
import com.yupi.wlsdbackend.mapper.MeetingDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【meeting_detail】的数据库操作Service实现
* @createDate 2024-02-26 21:13:41
*/
@Service
public class MeetingDetailServiceImpl extends ServiceImpl<MeetingDetailMapper, MeetingDetail>
    implements MeetingDetailService{

    /**
    * @author 95788
    * @description 针对表【blog_thumb】的数据库操作Service实现
    * @createDate 2024-03-01 20:04:22
    */
    @Service
    public static class BlogThumbServiceImpl extends ServiceImpl<BlogThumbMapper, BlogThumb>
        implements BlogThumbService {

    }
}




