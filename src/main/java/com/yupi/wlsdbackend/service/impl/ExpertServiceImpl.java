package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Expert;
import com.yupi.wlsdbackend.service.ExpertService;
import com.yupi.wlsdbackend.mapper.ExpertMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【expert(专家)】的数据库操作Service实现
* @createDate 2024-02-01 15:28:06
*/
@Service
public class ExpertServiceImpl extends ServiceImpl<ExpertMapper, Expert>
    implements ExpertService{

}




