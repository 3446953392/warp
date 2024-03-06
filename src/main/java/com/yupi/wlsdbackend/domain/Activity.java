package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 活动
 * @TableName activity
 */
@TableName(value ="activity")
@Data
public class Activity implements Serializable {
    /**
     * 活动id
     */
    @TableId(type = IdType.AUTO)
    private Integer itemId;

    /**
     * 活动名称
     */
    private String itemTitle;

    /**
     * 活动内容
     */
    private String itemContent;

    /**
     * 活动封面
     */
    private String itemCover;

    /**
     * 活动开始时间
     */
    private Date beginTime;

    /**
     * 活动结束时间
     */
    private Date finishTime;

    /**
     * 浏览量
     */
    private Integer itemViews;

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
        Activity other = (Activity) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemTitle() == null ? other.getItemTitle() == null : this.getItemTitle().equals(other.getItemTitle()))
            && (this.getItemContent() == null ? other.getItemContent() == null : this.getItemContent().equals(other.getItemContent()))
            && (this.getItemCover() == null ? other.getItemCover() == null : this.getItemCover().equals(other.getItemCover()))
            && (this.getBeginTime() == null ? other.getBeginTime() == null : this.getBeginTime().equals(other.getBeginTime()))
            && (this.getFinishTime() == null ? other.getFinishTime() == null : this.getFinishTime().equals(other.getFinishTime()))
            && (this.getItemViews() == null ? other.getItemViews() == null : this.getItemViews().equals(other.getItemViews()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemTitle() == null) ? 0 : getItemTitle().hashCode());
        result = prime * result + ((getItemContent() == null) ? 0 : getItemContent().hashCode());
        result = prime * result + ((getItemCover() == null) ? 0 : getItemCover().hashCode());
        result = prime * result + ((getBeginTime() == null) ? 0 : getBeginTime().hashCode());
        result = prime * result + ((getFinishTime() == null) ? 0 : getFinishTime().hashCode());
        result = prime * result + ((getItemViews() == null) ? 0 : getItemViews().hashCode());
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
        sb.append(", itemContent=").append(itemContent);
        sb.append(", itemCover=").append(itemCover);
        sb.append(", beginTime=").append(beginTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", itemViews=").append(itemViews);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}