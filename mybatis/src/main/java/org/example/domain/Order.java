package org.example.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

    private Integer orderId;
    private String orderSn;
    private Integer userId;
    private Integer amount;
    private Date createdAt;
    private Date updatedAt;

    // 用户信息
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "Order{" +
                "orderId=" + orderId +
                ", orderSn='" + orderSn + '\'' +
                ", userId=" + userId +
                ", amount=" + amount +
                ", createdAt=" + format.format(createdAt) +
                ", updatedAt=" + format.format(updatedAt) +
                '}';
    }
}
