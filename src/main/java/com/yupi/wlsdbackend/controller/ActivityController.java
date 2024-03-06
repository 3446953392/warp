package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yupi.wlsdbackend.common.R;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.dto.ActivityDto;
import com.yupi.wlsdbackend.dto.MeetingDto;
import com.yupi.wlsdbackend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

// import org.springframework.cache.annotation.CachePut;


@RestController
@Slf4j
public class ActivityController {
    @Resource
    private ActivityService activityService;
    @Resource
    private ActivityParticipationService activityParticipationService;
    @Resource
    private ActivityThumbService activityThumbService;

    @GetMapping("/getAllActivitys")
    public List<ActivityDto> getAllActivitys(@RequestParam("user_id") int user_id) {
        List<Activity> allActivitys = activityService.list();
        List<ActivityDto> activityDtos = new ArrayList<>();
        // 遍历每一条 Activity 记录，为其添加 isSubscribed 字段
        for (Activity activity : allActivitys) {
            int item_id = activity.getItemId();
            QueryWrapper<ActivityParticipation> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user_id).eq("item_id", item_id);
            QueryWrapper<ActivityThumb> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("user_id", user_id).eq("item_id", item_id);
            QueryWrapper<ActivityThumb> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("item_id", item_id);

            ActivityParticipation activityParticipation = activityParticipationService.getOne(queryWrapper);
            ActivityThumb activityThumb = activityThumbService.getOne(queryWrapper2);
            long thumbCount = activityThumbService.count(queryWrapper3);

            // 如果找到了对应的 ActivityParticipation 记录，说明用户已经订阅
            boolean isSubscribed = activityParticipation != null;
            boolean isThumbed = activityThumb != null;

            ActivityDto activityDto = new ActivityDto();

            activityDto.setActivity(activity);
            activityDto.setSubscribed(isSubscribed);
            activityDto.setThumbed(isThumbed);
            activityDto.setThumbCount(thumbCount);

            activityDtos.add(activityDto);
        }

        return activityDtos;
    }

    @GetMapping("/getActivityById")
    public ActivityDto getActivityById(@RequestParam("item_id") int item_id, @RequestParam("user_id") int user_id) {
        Activity SingleActivity = activityService.getById(item_id);

        QueryWrapper<ActivityParticipation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id).eq("item_id", item_id);
        QueryWrapper<ActivityThumb> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("user_id", user_id).eq("item_id", item_id);
        QueryWrapper<ActivityThumb> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("item_id", item_id);

        ActivityParticipation activityParticipation = activityParticipationService.getOne(queryWrapper);
        ActivityThumb activityThumb = activityThumbService.getOne(queryWrapper2);
        long thumbCount = activityThumbService.count(queryWrapper3);

        // 如果找到了对应的 ActivityParticipation 记录，说明用户已经订阅
        boolean isSubscribed = activityParticipation != null;
        boolean isThumbed = activityThumb != null;

        ActivityDto activityDto = new ActivityDto();

        activityDto.setActivity(SingleActivity);
        activityDto.setSubscribed(isSubscribed);
        activityDto.setThumbed(isThumbed);
        activityDto.setThumbCount(thumbCount);

        return activityDto;
    }

    @PostMapping("/setActivitySubscription")
    public R<ActivityParticipation> setActivityParticipation(@RequestBody ActivityParticipation activityParticipation) {
        activityParticipationService.save(activityParticipation);
        return R.success(null);
    }

    @PostMapping("/setActivityThumb")
    public R<ActivityThumb> setActivityThumb(@RequestBody ActivityThumb activityThumb) {
        activityThumbService.save(activityThumb);
        return R.success(null);
    }

    @PostMapping("/cancelActivityParticipation")
    public R<ActivityParticipation> cancelActivityParticipation(@RequestBody ActivityParticipation activityParticipation) {
        QueryWrapper<ActivityParticipation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", activityParticipation.getUserId()).eq("item_id", activityParticipation.getItemId());

        activityParticipationService.remove(queryWrapper);
        return R.success(null);
    }


    @PostMapping("/cancelActivityThumb")
    public R<ActivityThumb> cancelMeetingThumb(@RequestBody ActivityThumb activityThumb) {
        QueryWrapper<ActivityThumb> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", activityThumb.getUserId()).eq("item_id", activityThumb.getItemId());

        activityThumbService.remove(queryWrapper);
        return R.success(null);
    }

    @GetMapping("/activity/addViews")
    public R<Activity> addViews(@RequestParam("item_id") int item_id) {
        UpdateWrapper<Activity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("item_id", item_id).setSql("item_views = item_views + 1");

        // 更新操作，增加 item_views
        activityService.update(updateWrapper);
        return R.success(null);
    }

//    @GetMapping("/getActivityDetail")
//    public List<ActivityDetail> getActivityDetail(@RequestParam("item_id") int item_id) {
//        QueryWrapper<ActivityDetail> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("activity_id", item_id);
//
//        return activityDetailService.list(queryWrapper);
//    }

}
