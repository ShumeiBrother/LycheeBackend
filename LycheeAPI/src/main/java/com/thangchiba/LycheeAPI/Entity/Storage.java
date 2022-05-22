package com.thangchiba.LycheeAPI.Entity;

public class Storage {
    private String productId;
    private Long quantity;
    private java.sql.Date expiry;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public java.sql.Date getExpiry() {
        return this.expiry;
    }

    public void setExpiry(java.sql.Date expiry) {
        this.expiry = expiry;
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
