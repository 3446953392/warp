package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 组委会
 * @TableName committee
 */
@TableName(value ="committee")
@Data
public class Committee implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer committeeId;

    /**
     * 组委会名称
     */
    private String committeeName;

    /**
     * 组委会职务
     */
    private String committeePosition;

    /**
     * 组委会图片
     */
    private String committeeImg;

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
        Committee other = (Committee) that;
        return (this.getCommitteeId() == null ? other.getCommitteeId() == null : this.getCommitteeId().equals(other.getCommitteeId()))
            && (this.getCommitteeName() == null ? other.getCommitteeName() == null : this.getCommitteeName().equals(other.getCommitteeName()))
            && (this.getCommitteePosition() == null ? other.getCommitteePosition() == null : this.getCommitteePosition().equals(other.getCommitteePosition()))
            && (this.getCommitteeImg() == null ? other.getCommitteeImg() == null : this.getCommitteeImg().equals(other.getCommitteeImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommitteeId() == null) ? 0 : getCommitteeId().hashCode());
        result = prime * result + ((getCommitteeName() == null) ? 0 : getCommitteeName().hashCode());
        result = prime * result + ((getCommitteePosition() == null) ? 0 : getCommitteePosition().hashCode());
        result = prime * result + ((getCommitteeImg() == null) ? 0 : getCommitteeImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", committeeId=").append(committeeId);
        sb.append(", committeeName=").append(committeeName);
        sb.append(", committeePosition=").append(committeePosition);
        sb.append(", committeeImg=").append(committeeImg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}