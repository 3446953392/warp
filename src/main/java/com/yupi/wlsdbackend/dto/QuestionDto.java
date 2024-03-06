package com.yupi.wlsdbackend.dto;

import com.yupi.wlsdbackend.domain.Question;

public class QuestionDto {
    private Question question;
    private boolean isAnswered;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }
}