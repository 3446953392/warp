package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Committee;
import com.yupi.wlsdbackend.service.CommitteeService;
import com.yupi.wlsdbackend.mapper.CommitteeMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【committee(组委会)】的数据库操作Service实现
* @createDate 2024-02-01 15:28:06
*/
@Service
public class CommitteeServiceImpl extends ServiceImpl<CommitteeMapper, Committee>
    implements CommitteeService{

}




