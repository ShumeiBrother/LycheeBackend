package com.thangchiba.LycheeAPI.Request.Products;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;


@Data
public class CreateProductRequest {
    private String maker;
    private String madeIn;
    private String productName;
    private String size;
    private String color;
    private String description;
    private Integer receiptPrice;
    @Min(value = 0,message = "価格は０より大き")
    private Integer price;
    private Integer productPoint;
    @Min(value = 0,message = "重量は０より大き")
    private Integer weight;
    private String thumbnailImage;
    private String[] listImage;
    private String[] listCategoryId;
    private Date expiry;
}
