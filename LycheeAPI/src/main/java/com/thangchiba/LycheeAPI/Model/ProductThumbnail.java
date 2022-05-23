package com.thangchiba.LycheeAPI.Model;

public class ProductThumbnail {
    private String productId;
    private String productName;
    private String size;
    private String color;
    private String description;
    private Long price;
    private Long productPoint;
    private String thumbnailImage;
    private String listCategoryId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getProductPoint() {
        return productPoint;
    }

    public void setProductPoint(Long productPoint) {
        this.productPoint = productPoint;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getListCategoryId() {
        return listCategoryId;
    }

    public void setListCategoryId(String listCategoryId) {
        this.listCategoryId = listCategoryId;
    }
}
