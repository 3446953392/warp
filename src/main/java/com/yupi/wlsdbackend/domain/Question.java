package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 题目表
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * 题目id
     */
    @TableId(type = IdType.AUTO)
    private Integer questionId;

    /**
     * 题目内容
     */
    private String questionContent;

    /**
     * 选项1
     */
    private String option1;

    /**
     * 选项2
     */
    private String option2;

    /**
     * 选项3
     */
    private String option3;

    /**
     * 选项4
     */
    private String option4;

    /**
     * 正确选项id
     */
    private Integer correctOptionId;

    /**
     * 题目描述
     */
    private String questionDescription;

    /**
     * 位置
     */
    private String position;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Question other = (Question) that;
        return (this.getQuestionId() == null ? other.getQuestionId() == null : this.getQuestionId().equals(other.getQuestionId()))
            && (this.getQuestionContent() == null ? other.getQuestionContent() == null : this.getQuestionContent().equals(other.getQuestionContent()))
            && (this.getOption1() == null ? other.getOption1() == null : this.getOption1().equals(other.getOption1()))
            && (this.getOption2() == null ? other.getOption2() == null : this.getOption2().equals(other.getOption2()))
            && (this.getOption3() == null ? other.getOption3() == null : this.getOption3().equals(other.getOption3()))
            && (this.getOption4() == null ? other.getOption4() == null : this.getOption4().equals(other.getOption4()))
            && (this.getCorrectOptionId() == null ? other.getCorrectOptionId() == null : this.getCorrectOptionId().equals(other.getCorrectOptionId()))
            && (this.getQuestionDescription() == null ? other.getQuestionDescription() == null : this.getQuestionDescription().equals(other.getQuestionDescription()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getQuestionId() == null) ? 0 : getQuestionId().hashCode());
        result = prime * result + ((getQuestionContent() == null) ? 0 : getQuestionContent().hashCode());
        result = prime * result + ((getOption1() == null) ? 0 : getOption1().hashCode());
        result = prime * result + ((getOption2() == null) ? 0 : getOption2().hashCode());
        result = prime * result + ((getOption3() == null) ? 0 : getOption3().hashCode());
        result = prime * result + ((getOption4() == null) ? 0 : getOption4().hashCode());
        result = prime * result + ((getCorrectOptionId() == null) ? 0 : getCorrectOptionId().hashCode());
        result = prime * result + ((getQuestionDescription() == null) ? 0 : getQuestionDescription().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", questionId=").append(questionId);
        sb.append(", questionContent=").append(questionContent);
        sb.append(", option1=").append(option1);
        sb.append(", option2=").append(option2);
        sb.append(", option3=").append(option3);
        sb.append(", option4=").append(option4);
        sb.append(", correctOptionId=").append(correctOptionId);
        sb.append(", questionDescription=").append(questionDescription);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}