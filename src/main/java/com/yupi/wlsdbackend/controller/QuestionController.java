package com.yupi.wlsdbackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.wlsdbackend.domain.*;
import com.yupi.wlsdbackend.dto.QuestionDto;
import com.yupi.wlsdbackend.service.QuestionAnswerService;
import com.yupi.wlsdbackend.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class QuestionController {
    @Resource
    private QuestionService questionService;
    @Resource
    private QuestionAnswerService questionAnswerService;

    @GetMapping("/getAllQuestions")
    public List<QuestionDto> getAllQuestions(@RequestParam("user_id") int user_id) {
        List<Question> allQuestions = questionService.list();
        List<QuestionDto> questionDtos = new ArrayList<>();
        // 遍历每一条 Meeting 记录，为其添加 isSubscribed 字段
        for (Question question : allQuestions) {
            int questionId = question.getQuestionId();
            QueryWrapper<QuestionAnswer> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", user_id).eq("question_id", questionId);

            QuestionAnswer questionAnswer = questionAnswerService.getOne(queryWrapper);

            // 如果找到了对应的 MeetingSubscription 记录，说明用户已经订阅
            boolean isAnswered = questionAnswer != null;

            QuestionDto questionDto = new QuestionDto();

            questionDto.setQuestion(question);
            questionDto.setAnswered(isAnswered);

            questionDtos.add(questionDto);
        }

        return questionDtos;
    }

    @GetMapping("/getQuestionById")
    public QuestionDto getQuestionById(@RequestParam("question_id") int question_id, @RequestParam("user_id") int user_id) {
        Question SingleQuestion = questionService.getById(question_id);

        QueryWrapper<QuestionAnswer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", user_id).eq("question_id", question_id);

        QuestionAnswer questionAnswer = questionAnswerService.getOne(queryWrapper);

        // 如果找到了对应的 questionAnswer 记录，说明用户已经回答
        boolean isAnswered = questionAnswer != null;

        QuestionDto questionDto = new QuestionDto();

        questionDto.setQuestion(SingleQuestion);
        questionDto.setAnswered(isAnswered);

        return questionDto;
    }
}
