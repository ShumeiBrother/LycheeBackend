package com.thangchiba.LycheeAPI.Entity;

public class Customer {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String mailAddress;
    private String zipCode;
    private String prefecture;
    private String address;
    private Long countBuyTime;
    private Long totalMoneyUsed;
    private Long customerPoint;
    private String customerTypeId;
    private String facebook;
    private String cart;
    private java.sql.Date lastLogin;
    private java.sql.Date lastUpdateProfile;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPrefecture() {
        return this.prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCountBuyTime() {
        return this.countBuyTime;
    }

    public void setCountBuyTime(Long countBuyTime) {
        this.countBuyTime = countBuyTime;
    }

    public Long getTotalMoneyUsed() {
        return this.totalMoneyUsed;
    }

    public void setTotalMoneyUsed(Long totalMoneyUsed) {
        this.totalMoneyUsed = totalMoneyUsed;
    }

    public Long getCustomerPoint() {
        return this.customerPoint;
    }

    public void setCustomerPoint(Long customerPoint) {
        this.customerPoint = customerPoint;
    }

    public String getCustomerTypeId() {
        return this.customerTypeId;
    }

    public void setCustomerTypeId(String customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getFacebook() {
        return this.facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCart() {
        return this.cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public java.sql.Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(java.sql.Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public java.sql.Date getLastUpdateProfile() {
        return this.lastUpdateProfile;
    }

    public void setLastUpdateProfile(java.sql.Date lastUpdateProfile) {
        this.lastUpdateProfile = lastUpdateProfile;
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
