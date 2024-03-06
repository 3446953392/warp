package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 抽奖记录表
 * @TableName draw_record
 */
@TableName(value ="draw_record")
@Data
public class DrawRecord implements Serializable {
    /**
     * 抽奖记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer drawRecordId;

    /**
     * 奖品名
     */
    private String drawRecordName;

    /**
     * 中奖时间
     */
    private Date drawRecordTime;

    /**
     * 
     */
    private Integer userId;

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
        DrawRecord other = (DrawRecord) that;
        return (this.getDrawRecordId() == null ? other.getDrawRecordId() == null : this.getDrawRecordId().equals(other.getDrawRecordId()))
            && (this.getDrawRecordName() == null ? other.getDrawRecordName() == null : this.getDrawRecordName().equals(other.getDrawRecordName()))
            && (this.getDrawRecordTime() == null ? other.getDrawRecordTime() == null : this.getDrawRecordTime().equals(other.getDrawRecordTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrawRecordId() == null) ? 0 : getDrawRecordId().hashCode());
        result = prime * result + ((getDrawRecordName() == null) ? 0 : getDrawRecordName().hashCode());
        result = prime * result + ((getDrawRecordTime() == null) ? 0 : getDrawRecordTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drawRecordId=").append(drawRecordId);
        sb.append(", drawRecordName=").append(drawRecordName);
        sb.append(", drawRecordTime=").append(drawRecordTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}