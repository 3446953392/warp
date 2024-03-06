package com.yupi.wlsdbackend.service;

import com.yupi.wlsdbackend.domain.DrawRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 95788
 * @description 针对表【draw_record(抽奖记录表)】的数据库操作Service
 * @createDate 2024-02-20 23:06:18
 */
public interface DrawRecordService extends IService<DrawRecord> {

    List<DrawRecord> getDrawRecord(int user_id);
}
