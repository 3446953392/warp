package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Activity;
import com.yupi.wlsdbackend.service.ActivityService;
import com.yupi.wlsdbackend.mapper.ActivityMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【activity(活动)】的数据库操作Service实现
* @createDate 2024-02-27 10:44:01
*/
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity>
    implements ActivityService{

}




