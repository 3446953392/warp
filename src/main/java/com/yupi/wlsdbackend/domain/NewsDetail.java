package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName news_detail
 */
@TableName(value ="news_detail")
@Data
public class NewsDetail implements Serializable {
    /**
     * 新闻内容id
     */
    @TableId(type = IdType.AUTO)
    private Integer newsDetailId;

    /**
     * 新闻id
     */
    private Integer newsId;

    /**
     * 新闻内容1
     */
    private String detail1;

    /**
     * 新闻内容2
     */
    private String detail2;

    /**
     * 新闻内容3
     */
    private String detail3;

    /**
     * 新闻内容4
     */
    private String detail4;

    /**
     * 新闻内容5
     */
    private String detail5;

    /**
     * 新闻内容6
     */
    private String detail6;

    /**
     * 新闻内容7
     */
    private String detail7;

    /**
     * 新闻内容8
     */
    private String detail8;

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
        NewsDetail other = (NewsDetail) that;
        return (this.getNewsDetailId() == null ? other.getNewsDetailId() == null : this.getNewsDetailId().equals(other.getNewsDetailId()))
            && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
            && (this.getDetail1() == null ? other.getDetail1() == null : this.getDetail1().equals(other.getDetail1()))
            && (this.getDetail2() == null ? other.getDetail2() == null : this.getDetail2().equals(other.getDetail2()))
            && (this.getDetail3() == null ? other.getDetail3() == null : this.getDetail3().equals(other.getDetail3()))
            && (this.getDetail4() == null ? other.getDetail4() == null : this.getDetail4().equals(other.getDetail4()))
            && (this.getDetail5() == null ? other.getDetail5() == null : this.getDetail5().equals(other.getDetail5()))
            && (this.getDetail6() == null ? other.getDetail6() == null : this.getDetail6().equals(other.getDetail6()))
            && (this.getDetail7() == null ? other.getDetail7() == null : this.getDetail7().equals(other.getDetail7()))
            && (this.getDetail8() == null ? other.getDetail8() == null : this.getDetail8().equals(other.getDetail8()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsDetailId() == null) ? 0 : getNewsDetailId().hashCode());
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getDetail1() == null) ? 0 : getDetail1().hashCode());
        result = prime * result + ((getDetail2() == null) ? 0 : getDetail2().hashCode());
        result = prime * result + ((getDetail3() == null) ? 0 : getDetail3().hashCode());
        result = prime * result + ((getDetail4() == null) ? 0 : getDetail4().hashCode());
        result = prime * result + ((getDetail5() == null) ? 0 : getDetail5().hashCode());
        result = prime * result + ((getDetail6() == null) ? 0 : getDetail6().hashCode());
        result = prime * result + ((getDetail7() == null) ? 0 : getDetail7().hashCode());
        result = prime * result + ((getDetail8() == null) ? 0 : getDetail8().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsDetailId=").append(newsDetailId);
        sb.append(", newsId=").append(newsId);
        sb.append(", detail1=").append(detail1);
        sb.append(", detail2=").append(detail2);
        sb.append(", detail3=").append(detail3);
        sb.append(", detail4=").append(detail4);
        sb.append(", detail5=").append(detail5);
        sb.append(", detail6=").append(detail6);
        sb.append(", detail7=").append(detail7);
        sb.append(", detail8=").append(detail8);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}