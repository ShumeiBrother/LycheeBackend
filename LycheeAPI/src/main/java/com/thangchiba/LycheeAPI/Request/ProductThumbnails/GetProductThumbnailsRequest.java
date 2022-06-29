package com.thangchiba.LycheeAPI.Request.ProductThumbnails;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
public class GetProductThumbnailsRequest {
    private String categoryId;
    private Date fromDate;
    private Date toDate;
    private Integer fromPrice;
    private Integer toPrice;
    private String orderBy;
    @Min(value=10,message = "ページの表示対象数は10より大き")
    private Integer itemPerPage;
    @Min(0)
    private Integer page;
}

