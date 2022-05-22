package com.thangchiba.LycheeAPI.Entity;

public class Shipment {
    private String shipmentId;
    private String productId;
    private Long status;
    private Long quantity;
    private java.sql.Date shipmentDate;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getShipmentId() {
        return this.shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
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

    public java.sql.Date getShipmentDate() {
        return this.shipmentDate;
    }

    public void setShipmentDate(java.sql.Date shipmentDate) {
        this.shipmentDate = shipmentDate;
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
