package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 博客表
 * @TableName blog
 */
@TableName(value ="blog")
@Data
public class Blog implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 
     */
    private Integer userId;

    /**
     * 回复的层次，0为根评论，以此类推
     */
    private Integer replyLevel;

    /**
     * 回复的评论id
     */
    private Integer replyParentId;

    /**
     * 评论时间
     */
    private Date replyTime;

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
        Blog other = (Blog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getReplyLevel() == null ? other.getReplyLevel() == null : this.getReplyLevel().equals(other.getReplyLevel()))
            && (this.getReplyParentId() == null ? other.getReplyParentId() == null : this.getReplyParentId().equals(other.getReplyParentId()))
            && (this.getReplyTime() == null ? other.getReplyTime() == null : this.getReplyTime().equals(other.getReplyTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getReplyLevel() == null) ? 0 : getReplyLevel().hashCode());
        result = prime * result + ((getReplyParentId() == null) ? 0 : getReplyParentId().hashCode());
        result = prime * result + ((getReplyTime() == null) ? 0 : getReplyTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", userId=").append(userId);
        sb.append(", replyLevel=").append(replyLevel);
        sb.append(", replyParentId=").append(replyParentId);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}