package com.thangchiba.LycheeAPI.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
