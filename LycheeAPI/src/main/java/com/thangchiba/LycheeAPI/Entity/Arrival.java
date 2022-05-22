package com.thangchiba.LycheeAPI.Entity;

public class Arrival {
    private String arrivalId;
    private String productId;
    private Long status;
    private Long quantity;
    private java.sql.Date arrivalDate;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getArrivalId() {
        return this.arrivalId;
    }

    public void setArrivalId(String arrivalId) {
        this.arrivalId = arrivalId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public java.sql.Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(java.sql.Date arrivalDate) {
        this.arrivalDate = arrivalDate;
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
