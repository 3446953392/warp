package com.yupi.wlsdbackend.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 积分详情表
 * @TableName integral_detail
 */
@TableName(value ="integral_detail")
@Data
public class IntegralDetail implements Serializable {
    /**
     * 积分id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 积分获得名称
     */
    private String integralName;

    /**
     * 积分数
     */
    private Integer integralAmount;

    /**
     * 
     */
    private Integer userId;

    /**
     * 中奖时间
     */
    private Date integralTime;

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
        IntegralDetail other = (IntegralDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIntegralName() == null ? other.getIntegralName() == null : this.getIntegralName().equals(other.getIntegralName()))
            && (this.getIntegralAmount() == null ? other.getIntegralAmount() == null : this.getIntegralAmount().equals(other.getIntegralAmount()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getIntegralTime() == null ? other.getIntegralTime() == null : this.getIntegralTime().equals(other.getIntegralTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIntegralName() == null) ? 0 : getIntegralName().hashCode());
        result = prime * result + ((getIntegralAmount() == null) ? 0 : getIntegralAmount().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getIntegralTime() == null) ? 0 : getIntegralTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", integralName=").append(integralName);
        sb.append(", integralAmount=").append(integralAmount);
        sb.append(", userId=").append(userId);
        sb.append(", integralTime=").append(integralTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}