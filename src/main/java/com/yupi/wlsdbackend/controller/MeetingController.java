package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yupi.wlsdbackend.common.R;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.dto.MeetingDto;
import com.yupi.wlsdbackend.service.MeetingDetailService;
import com.yupi.wlsdbackend.service.MeetingService;
import com.yupi.wlsdbackend.service.MeetingSubscriptionService;
import com.yupi.wlsdbackend.service.MeetingThumbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MeetingController {
    @Resource
    private MeetingService meetingService;
    @Resource
    private MeetingSubscriptionService meetingSubscriptionService;
    @Resource
    private MeetingThumbService meetingThumbService;
    @Resource
    private MeetingDetailService meetingDetailService;

    @GetMapping("/getAllMeetings")
    public List<MeetingDto> getAllMeetings(@RequestParam("user_id") int user_id) {
        List<Meeting> allMeetings = meetingService.list();
        List<MeetingDto> meetingDtos = new ArrayList<>();
        // 遍历每一条 Meeting 记录，为其添加 isSubscribed 字段
        for (Meeting meeting : allMeetings) {
            int item_id = meeting.getItemId();
            QueryWrapper<MeetingSubscription> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user_id).eq("item_id", item_id);
            QueryWrapper<MeetingThumb> queryWrapper2 = new QueryWrapper<>();
            queryWrapper2.eq("user_id", user_id).eq("item_id", item_id);
            QueryWrapper<MeetingThumb> queryWrapper3 = new QueryWrapper<>();
            queryWrapper3.eq("item_id", item_id);

            MeetingSubscription meetingSubscription = meetingSubscriptionService.getOne(queryWrapper);
            MeetingThumb meetingThumb = meetingThumbService.getOne(queryWrapper2);
            long thumbCount = meetingThumbService.count(queryWrapper3);

            // 如果找到了对应的 MeetingSubscription 记录，说明用户已经订阅
            boolean isSubscribed = meetingSubscription != null;
            boolean isThumbed = meetingThumb != null;

            MeetingDto meetingDto = new MeetingDto();

            meetingDto.setMeeting(meeting);
            meetingDto.setSubscribed(isSubscribed);
            meetingDto.setThumbed(isThumbed);
            meetingDto.setThumbCount(thumbCount);

            meetingDtos.add(meetingDto);
        }

        return meetingDtos;
    }

    @GetMapping("/getMeetingById")
    public MeetingDto getMeetingById(@RequestParam("item_id") int item_id, @RequestParam("user_id") int user_id) {
        Meeting SingleMeeting = meetingService.getById(item_id);

        QueryWrapper<MeetingSubscription> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id).eq("item_id", item_id);
        QueryWrapper<MeetingThumb> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("user_id", user_id).eq("item_id", item_id);
        QueryWrapper<MeetingThumb> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("item_id", item_id);

        MeetingSubscription meetingSubscription = meetingSubscriptionService.getOne(queryWrapper);
        MeetingThumb meetingThumb = meetingThumbService.getOne(queryWrapper2);
        long thumbCount = meetingThumbService.count(queryWrapper3);

        // 如果找到了对应的 MeetingSubscription 记录，说明用户已经订阅
        boolean isSubscribed = meetingSubscription != null;
        boolean isThumbed = meetingThumb != null;

        MeetingDto meetingDto = new MeetingDto();

        meetingDto.setMeeting(SingleMeeting);
        meetingDto.setSubscribed(isSubscribed);
        meetingDto.setThumbed(isThumbed);
        meetingDto.setThumbCount(thumbCount);

        return meetingDto;
    }

    @PostMapping("/setMeetingSubscription")
    public R<MeetingSubscription> setMeetingSubscription(@RequestBody MeetingSubscription meetingSubscription) {
        meetingSubscriptionService.save(meetingSubscription);
        return R.success(null);
    }

    @PostMapping("/setMeetingThumb")
    public R<MeetingThumb> setMeetingThumb(@RequestBody MeetingThumb meetingThumb) {
        meetingThumbService.save(meetingThumb);
        return R.success(null);
    }

    @PostMapping("/cancelMeetingSubscription")
    public R<MeetingSubscription> cancelMeetingSubscription(@RequestBody MeetingSubscription meetingSubscription) {
        QueryWrapper<MeetingSubscription> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", meetingSubscription.getUserId()).eq("item_id", meetingSubscription.getItemId());

        meetingSubscriptionService.remove(queryWrapper);
        return R.success(null);
    }


    @PostMapping("/cancelMeetingThumb")
    public R<MeetingThumb> cancelMeetingThumb(@RequestBody MeetingThumb meetingThumb) {
        QueryWrapper<MeetingThumb> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", meetingThumb.getUserId()).eq("item_id", meetingThumb.getItemId());

        meetingThumbService.remove(queryWrapper);
        return R.success(null);
    }

    @GetMapping("/meeting/addViews")
    public R<Meeting> addViews(@RequestParam("item_id") int item_id) {
        UpdateWrapper<Meeting> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("item_id", item_id).setSql("item_views = item_views + 1");

        // 更新操作，增加 item_views
        meetingService.update(updateWrapper);
        return R.success(null);
    }

    @GetMapping("/getMeetingDetail")
    public List<MeetingDetail> getMeetingDetail(@RequestParam("item_id") int item_id) {
        QueryWrapper<MeetingDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("meeting_id", item_id);

        return meetingDetailService.list(queryWrapper);
    }
}
