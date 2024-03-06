package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.DrawRecord;
import com.yupi.wlsdbackend.service.DrawRecordService;
import com.yupi.wlsdbackend.mapper.DrawRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 95788
 * @description 针对表【draw_record(抽奖记录表)】的数据库操作Service实现
 * @createDate 2024-02-20 23:06:18
 */
@Service
@Slf4j
public class DrawRecordServiceImpl extends ServiceImpl<DrawRecordMapper, DrawRecord>
        implements DrawRecordService {
    @Resource
    private DrawRecordMapper drawRecordMapper;

    public List<DrawRecord> getDrawRecord(int user_id) {
        QueryWrapper<DrawRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id);

        List<DrawRecord> resultList = drawRecordMapper.selectList(queryWrapper);
        log.info(resultList.toString());
        return resultList;
    }
}




