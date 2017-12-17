package priv.thinkam.rent.dao.model;

import java.io.Serializable;

public class Stuff implements Serializable {
    /**
     * 物品编号
     *
     * @mbg.generated
     */
    private Integer stuffId;

    /**
     * 类别编号
     *
     * @mbg.generated
     */
    private Integer categoryId;

    /**
     * 物品名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 押金(rmb)
     *
     * @mbg.generated
     */
    private Integer deposit;

    /**
     * 租金（rmb/day）
     *
     * @mbg.generated
     */
    private Integer rental;

    /**
     * 物品状态（0:未租；1:申请租用；2:已租）
     *
     * @mbg.generated
     */
    private Byte status;

    private static final long serialVersionUID = 1L;

    public Integer getStuffId() {
        return stuffId;
    }

    public void setStuffId(Integer stuffId) {
        this.stuffId = stuffId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Integer getRental() {
        return rental;
    }

    public void setRental(Integer rental) {
        this.rental = rental;
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
        sb.append(", stuffId=").append(stuffId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", name=").append(name);
        sb.append(", deposit=").append(deposit);
        sb.append(", rental=").append(rental);
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
        Stuff other = (Stuff) that;
        return (this.getStuffId() == null ? other.getStuffId() == null : this.getStuffId().equals(other.getStuffId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getRental() == null ? other.getRental() == null : this.getRental().equals(other.getRental()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStuffId() == null) ? 0 : getStuffId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getRental() == null) ? 0 : getRental().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}