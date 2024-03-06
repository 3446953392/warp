package com.yupi.wlsdbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.wlsdbackend.domain.Question;
import com.yupi.wlsdbackend.service.QuestionService;
import com.yupi.wlsdbackend.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 95788
* @description 针对表【question(题目表)】的数据库操作Service实现
* @createDate 2024-03-02 11:44:45
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




