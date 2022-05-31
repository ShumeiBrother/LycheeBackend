package com.thangchiba.LycheeAPI.Response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetProductThumbnailsResponse {
    private String productId;
    private String productName;
    private String size;
    private String color;
    private String description;
    private Long price;
    private Long productPoint;
    private String thumbnailImage;
    private String listCategoryName;
}

