package com.thangchiba.LycheeAPI.Entity;

public class CustomerType {
    private String customerTypeId;
    private String customerTypeName;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getCustomerTypeId() {
        return this.customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return this.customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
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
