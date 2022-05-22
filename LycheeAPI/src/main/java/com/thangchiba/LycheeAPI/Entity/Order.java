package com.thangchiba.LycheeAPI.Entity;

public class Order {
    private String orderId;
    private String productId;
    private String customerId;
    private Long status;
    private Long quantity;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public java.sql.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.sql.Date createDate) {
        this.createDate = createDate;
    }

    public java.sql.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.sql.Date updateDate) {
        this.updateDate = updateDate;
    }
}
