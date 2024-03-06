package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Meeting;
import com.yupi.wlsdbackend.service.MeetingService;
import com.yupi.wlsdbackend.mapper.MeetingMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【meeting(会议)】的数据库操作Service实现
* @createDate 2024-02-05 15:11:55
*/
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingMapper, Meeting>
    implements MeetingService{


}




