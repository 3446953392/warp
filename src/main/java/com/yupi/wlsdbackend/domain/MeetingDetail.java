package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName meeting_detail
 */
@TableName(value ="meeting_detail")
@Data
public class MeetingDetail implements Serializable {
    /**
     * 议程内容id
     */
    @TableId(type = IdType.AUTO)
    private Integer meetingDetailId;

    /**
     * 会议id
     */
    private Integer meetingId;

    /**
     * 议程时间
     */
    private String time;

    /**
     * 议程标题
     */
    private String title;

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
        MeetingDetail other = (MeetingDetail) that;
        return (this.getMeetingDetailId() == null ? other.getMeetingDetailId() == null : this.getMeetingDetailId().equals(other.getMeetingDetailId()))
            && (this.getMeetingId() == null ? other.getMeetingId() == null : this.getMeetingId().equals(other.getMeetingId()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMeetingDetailId() == null) ? 0 : getMeetingDetailId().hashCode());
        result = prime * result + ((getMeetingId() == null) ? 0 : getMeetingId().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", meetingDetailId=").append(meetingDetailId);
        sb.append(", meetingId=").append(meetingId);
        sb.append(", time=").append(time);
        sb.append(", title=").append(title);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}