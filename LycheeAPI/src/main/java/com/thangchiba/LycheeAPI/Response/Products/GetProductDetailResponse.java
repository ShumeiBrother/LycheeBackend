package com.thangchiba.LycheeAPI.Response.Products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GetProductDetailResponse {
    private String productId;
    @Nullable
    private String maker;
    @Nullable
    private String madeIn;
    private String productName;
    @Nullable
    private String size;
    @Nullable
    private String color;
    @Nullable
    private String description;
    private Integer receiptPrice;
    private Integer price;
    @Nullable
    private Integer productPoint;
    @Nullable
    private Integer weight;
    @Nullable
    private String thumbnailImage;
    @Nullable
    private String listImage;
    private String listCategoryName;
    private Date expiry;
}
