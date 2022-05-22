package com.thangchiba.LycheeAPI.Entity;

public class Product {
    private String productId;
    private String maker;
    private String madeIn;
    private String productName;
    private String size;
    private String color;
    private String description;
    private Long receiptPrice;
    private Long price;
    private Long productPoint;
    private Long weight;
    private String thumbnailImage;
    private String listImage;
    private String listCategoryId;
    private java.sql.Date expiry;
    private java.sql.Date createDate;
    private java.sql.Date updateDate;

    public Product(String productId, String productName, String description, Long price, String thumbnailImage, String listCategoryId) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.thumbnailImage = thumbnailImage;
        this.listCategoryId = listCategoryId;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getMadeIn() {
        return this.madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReceiptPrice() {
        return this.receiptPrice;
    }

    public void setReceiptPrice(Long receiptPrice) {
        this.receiptPrice = receiptPrice;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getProductPoint() {
        return this.productPoint;
    }

    public void setProductPoint(Long productPoint) {
        this.productPoint = productPoint;
    }

    public Long getWeight() {
        return this.weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getThumbnailImage() {
        return this.thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getListImage() {
        return this.listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public String getListCategoryId() {
        return this.listCategoryId;
    }

    public void setListCategoryId(String listCategoryId) {
        this.listCategoryId = listCategoryId;
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
