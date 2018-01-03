package priv.thinkam.rent.dao.model;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    /**
     * 出租项编号
     *
     * @mbg.generated
     */
    private Integer itemId;

    /**
     * 用户编号
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 物品编号
     *
     * @mbg.generated
     */
    private Integer stuffId;

    /**
     * 租用日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 租用天数
     *
     * @mbg.generated
     */
    private Integer rentDay;

    /**
     * 归还日期
     *
     * @mbg.generated
     */
    private Date endTime;

    /**
     * 申请时间
     *
     * @mbg.generated
     */
    private Date applyTime;

    /**
     * 状态（0：申请中；1：不通过；2：租用中；3： 已归还）
     *
     * @mbg.generated
     */
    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStuffId() {
        return stuffId;
    }

    public void setStuffId(Integer stuffId) {
        this.stuffId = stuffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRentDay() {
        return rentDay;
    }

    public void setRentDay(Integer rentDay) {
        this.rentDay = rentDay;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", userId=").append(userId);
        sb.append(", stuffId=").append(stuffId);
        sb.append(", createTime=").append(createTime);
        sb.append(", rentDay=").append(rentDay);
        sb.append(", endTime=").append(endTime);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

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
        Item other = (Item) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStuffId() == null ? other.getStuffId() == null : this.getStuffId().equals(other.getStuffId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRentDay() == null ? other.getRentDay() == null : this.getRentDay().equals(other.getRentDay()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStuffId() == null) ? 0 : getStuffId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRentDay() == null) ? 0 : getRentDay().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}