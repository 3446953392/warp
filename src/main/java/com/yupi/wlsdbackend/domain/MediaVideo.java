package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 精彩视频
 * @TableName media_video
 */
@TableName(value ="media_video")
@Data
public class MediaVideo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer videoId;

    /**
     * 视频标题
     */
    private String videoTitle;

    /**
     * 视频封面
     */
    private String videoCover;

    /**
     * 浏览量
     */
    private Integer videoViews;

    /**
     * 视频标签
     */
    private String videoTag;

    /**
     * 视频播放地址
     */
    private String videoAddress;

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
        MediaVideo other = (MediaVideo) that;
        return (this.getVideoId() == null ? other.getVideoId() == null : this.getVideoId().equals(other.getVideoId()))
            && (this.getVideoTitle() == null ? other.getVideoTitle() == null : this.getVideoTitle().equals(other.getVideoTitle()))
            && (this.getVideoCover() == null ? other.getVideoCover() == null : this.getVideoCover().equals(other.getVideoCover()))
            && (this.getVideoViews() == null ? other.getVideoViews() == null : this.getVideoViews().equals(other.getVideoViews()))
            && (this.getVideoTag() == null ? other.getVideoTag() == null : this.getVideoTag().equals(other.getVideoTag()))
            && (this.getVideoAddress() == null ? other.getVideoAddress() == null : this.getVideoAddress().equals(other.getVideoAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVideoId() == null) ? 0 : getVideoId().hashCode());
        result = prime * result + ((getVideoTitle() == null) ? 0 : getVideoTitle().hashCode());
        result = prime * result + ((getVideoCover() == null) ? 0 : getVideoCover().hashCode());
        result = prime * result + ((getVideoViews() == null) ? 0 : getVideoViews().hashCode());
        result = prime * result + ((getVideoTag() == null) ? 0 : getVideoTag().hashCode());
        result = prime * result + ((getVideoAddress() == null) ? 0 : getVideoAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", videoId=").append(videoId);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", videoCover=").append(videoCover);
        sb.append(", videoViews=").append(videoViews);
        sb.append(", videoTag=").append(videoTag);
        sb.append(", videoAddress=").append(videoAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}