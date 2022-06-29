package com.thangchiba.LycheeAPI.Request.Products;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.Date;


@Data
public class UpdateProductRequest {
    private String productId;
    private String maker;
    private String madeIn;
    private String productName;
    private String size;
    private String color;
    private String description;
    private Integer receiptPrice;
    private Integer price;
    private Integer productPoint;
    private Integer weight;
    private String thumbnailImage;
    private String[] listImage;
    private String[] listCategoryId;
    private Date expiry;

}
