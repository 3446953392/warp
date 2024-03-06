package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 会议
 *
 * @TableName meeting
 */
@TableName(value = "meeting")
@Data
public class Meeting implements Serializable {
    /**
     * 会议id
     */
    @TableId(type = IdType.AUTO)
    private Integer itemId;

    /**
     * 会议名称
     */
    private String itemTitle;

    /**
     * 会议类型
     */
    private String itemType;

    /**
     * 会议日期
     */
    private String itemDate;

    /**
     * 会议时间
     */
    private String itemTime;

    /**
     * 会议地点
     */
    private String itemLocation;

    /**
     * 会议内容
     */
    private String itemContent;

    /**
     * 浏览量
     */
    private Integer itemViews;

    /**
     * 播放地址
     */
    private String itemAddress;

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
        Meeting other = (Meeting) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
                && (this.getItemTitle() == null ? other.getItemTitle() == null : this.getItemTitle().equals(other.getItemTitle()))
                && (this.getItemType() == null ? other.getItemType() == null : this.getItemType().equals(other.getItemType()))
                && (this.getItemDate() == null ? other.getItemDate() == null : this.getItemDate().equals(other.getItemDate()))
                && (this.getItemTime() == null ? other.getItemTime() == null : this.getItemTime().equals(other.getItemTime()))
                && (this.getItemLocation() == null ? other.getItemLocation() == null : this.getItemLocation().equals(other.getItemLocation()))
                && (this.getItemContent() == null ? other.getItemContent() == null : this.getItemContent().equals(other.getItemContent()))
                && (this.getItemViews() == null ? other.getItemViews() == null : this.getItemViews().equals(other.getItemViews()))
                && (this.getItemAddress() == null ? other.getItemAddress() == null : this.getItemAddress().equals(other.getItemAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemTitle() == null) ? 0 : getItemTitle().hashCode());
        result = prime * result + ((getItemType() == null) ? 0 : getItemType().hashCode());
        result = prime * result + ((getItemDate() == null) ? 0 : getItemDate().hashCode());
        result = prime * result + ((getItemTime() == null) ? 0 : getItemTime().hashCode());
        result = prime * result + ((getItemLocation() == null) ? 0 : getItemLocation().hashCode());
        result = prime * result + ((getItemContent() == null) ? 0 : getItemContent().hashCode());
        result = prime * result + ((getItemViews() == null) ? 0 : getItemViews().hashCode());
        result = prime * result + ((getItemAddress() == null) ? 0 : getItemAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", itemTitle=").append(itemTitle);
        sb.append(", itemType=").append(itemType);
        sb.append(", itemDate=").append(itemDate);
        sb.append(", itemTime=").append(itemTime);
        sb.append(", itemLocation=").append(itemLocation);
        sb.append(", itemContent=").append(itemContent);
        sb.append(", itemViews=").append(itemViews);
        sb.append(", itemAddress=").append(itemAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


}