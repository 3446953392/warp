package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 积分详情表
 * @TableName integral_gifts
 */
@TableName(value ="integral_gifts")
@Data
public class IntegralGifts implements Serializable {
    /**
     * 礼品id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 礼品名称
     */
    private String giftName;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 图片
     */
    private String img;

    /**
     * 剩余数量
     */
    private Integer restAmount;

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
        IntegralGifts other = (IntegralGifts) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getGiftName() == null ? other.getGiftName() == null : this.getGiftName().equals(other.getGiftName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getRestAmount() == null ? other.getRestAmount() == null : this.getRestAmount().equals(other.getRestAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getGiftName() == null) ? 0 : getGiftName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getRestAmount() == null) ? 0 : getRestAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", giftName=").append(giftName);
        sb.append(", price=").append(price);
        sb.append(", img=").append(img);
        sb.append(", restAmount=").append(restAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}