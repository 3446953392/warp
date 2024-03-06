package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 新闻资讯
 * @TableName news
 */
@TableName(value ="news")
@Data
public class News implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer newsId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻描述
     */
    private String newsDescription;

    /**
     * 图片地址
     */
    private String newsUrl;

    /**
     * 新闻分类
     */
    private String newsTag;

    /**
     * 新闻日期
     */
    private String newsDate;

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
        News other = (News) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
            && (this.getNewsDescription() == null ? other.getNewsDescription() == null : this.getNewsDescription().equals(other.getNewsDescription()))
            && (this.getNewsUrl() == null ? other.getNewsUrl() == null : this.getNewsUrl().equals(other.getNewsUrl()))
            && (this.getNewsTag() == null ? other.getNewsTag() == null : this.getNewsTag().equals(other.getNewsTag()))
            && (this.getNewsDate() == null ? other.getNewsDate() == null : this.getNewsDate().equals(other.getNewsDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getNewsDescription() == null) ? 0 : getNewsDescription().hashCode());
        result = prime * result + ((getNewsUrl() == null) ? 0 : getNewsUrl().hashCode());
        result = prime * result + ((getNewsTag() == null) ? 0 : getNewsTag().hashCode());
        result = prime * result + ((getNewsDate() == null) ? 0 : getNewsDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsDescription=").append(newsDescription);
        sb.append(", newsUrl=").append(newsUrl);
        sb.append(", newsTag=").append(newsTag);
        sb.append(", newsDate=").append(newsDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}