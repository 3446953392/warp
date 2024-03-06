package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 专家
 * @TableName expert
 */
@TableName(value ="expert")
@Data
public class Expert implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer expertId;

    /**
     * 专家名称
     */
    private String expertName;

    /**
     * 专家职务
     */
    private String expertPosition;

    /**
     * 专家图片
     */
    private String expertImg;

    /**
     * 专家演讲
     */
    private String speechVideo;

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
        Expert other = (Expert) that;
        return (this.getExpertId() == null ? other.getExpertId() == null : this.getExpertId().equals(other.getExpertId()))
            && (this.getExpertName() == null ? other.getExpertName() == null : this.getExpertName().equals(other.getExpertName()))
            && (this.getExpertPosition() == null ? other.getExpertPosition() == null : this.getExpertPosition().equals(other.getExpertPosition()))
            && (this.getExpertImg() == null ? other.getExpertImg() == null : this.getExpertImg().equals(other.getExpertImg()))
            && (this.getSpeechVideo() == null ? other.getSpeechVideo() == null : this.getSpeechVideo().equals(other.getSpeechVideo()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getExpertId() == null) ? 0 : getExpertId().hashCode());
        result = prime * result + ((getExpertName() == null) ? 0 : getExpertName().hashCode());
        result = prime * result + ((getExpertPosition() == null) ? 0 : getExpertPosition().hashCode());
        result = prime * result + ((getExpertImg() == null) ? 0 : getExpertImg().hashCode());
        result = prime * result + ((getSpeechVideo() == null) ? 0 : getSpeechVideo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expertId=").append(expertId);
        sb.append(", expertName=").append(expertName);
        sb.append(", expertPosition=").append(expertPosition);
        sb.append(", expertImg=").append(expertImg);
        sb.append(", speechVideo=").append(speechVideo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}