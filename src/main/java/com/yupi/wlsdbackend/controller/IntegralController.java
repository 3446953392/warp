package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.yupi.wlsdbackend.common.R;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class IntegralController {
    @Resource
    private DrawRecordService drawRecordService;
    @Resource
    private IntegralDetailService integralDetailService;
    @Resource
    private IntegralGiftsService integralGiftsService;
    @Resource
    private UserService userService;

    @GetMapping("/getIntegralGifts")
    public List<IntegralGifts> getIntegralGifts() {
        return integralGiftsService.list();
    }

    @GetMapping("/getIntegralDetail")
    public List<IntegralDetail> getIntegralDetail(@RequestParam("user_id") int user_id) {
        QueryWrapper<IntegralDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id);
        log.info(String.valueOf(user_id));
        return integralDetailService.list(queryWrapper);
    }

    @PostMapping("/addIntegralDetail")
    public R<IntegralDetail> addIntegralDetail(@RequestBody IntegralDetail integralDetail) {
        integralDetailService.save(integralDetail);
        // 构建更新条件
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", integralDetail.getUserId()).setSql("integral = integral +" + integralDetail.getIntegralAmount());

        // 执行更新操作
        userService.update(updateWrapper);
        return R.success(integralDetail);
    }

    @GetMapping("/getDrawRecord")
    public List<DrawRecord> getDrawRecord(@RequestParam("user_id") int user_id) {
        return drawRecordService.getDrawRecord(user_id);
    }

    @PostMapping("/addNewRecord")
    public R<DrawRecord> addNewRecord(@RequestBody DrawRecord drawRecord) {
        drawRecordService.save(drawRecord);
        return R.success(drawRecord);
    }
}
