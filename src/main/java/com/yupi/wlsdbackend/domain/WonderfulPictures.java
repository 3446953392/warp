package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 精彩图片
 * @TableName wonderful_pictures
 */
@TableName(value ="wonderful_pictures")
@Data
public class WonderfulPictures implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer pictureId;

    /**
     * 图片标题
     */
    private String pictureTitle;

    /**
     * 图片地址
     */
    private String pictureUrl;

    /**
     * 图片标签
     */
    private String pictureTag;

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
        WonderfulPictures other = (WonderfulPictures) that;
        return (this.getPictureId() == null ? other.getPictureId() == null : this.getPictureId().equals(other.getPictureId()))
            && (this.getPictureTitle() == null ? other.getPictureTitle() == null : this.getPictureTitle().equals(other.getPictureTitle()))
            && (this.getPictureUrl() == null ? other.getPictureUrl() == null : this.getPictureUrl().equals(other.getPictureUrl()))
            && (this.getPictureTag() == null ? other.getPictureTag() == null : this.getPictureTag().equals(other.getPictureTag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPictureId() == null) ? 0 : getPictureId().hashCode());
        result = prime * result + ((getPictureTitle() == null) ? 0 : getPictureTitle().hashCode());
        result = prime * result + ((getPictureUrl() == null) ? 0 : getPictureUrl().hashCode());
        result = prime * result + ((getPictureTag() == null) ? 0 : getPictureTag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pictureId=").append(pictureId);
        sb.append(", pictureTitle=").append(pictureTitle);
        sb.append(", pictureUrl=").append(pictureUrl);
        sb.append(", pictureTag=").append(pictureTag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}