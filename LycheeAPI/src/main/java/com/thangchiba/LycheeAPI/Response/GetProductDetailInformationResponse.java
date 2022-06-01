package com.thangchiba.LycheeAPI.Response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GetProductDetailInformationResponse {
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
    private String listImage;
    private String listCategoryName;
    private Date expiry;
}
