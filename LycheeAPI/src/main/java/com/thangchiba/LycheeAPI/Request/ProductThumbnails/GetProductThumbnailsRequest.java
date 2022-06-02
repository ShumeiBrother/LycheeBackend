package com.thangchiba.LycheeAPI.Request.ProductThumbnails;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetProductThumbnailsRequest {
    private String categoryId;
    private Date fromDate;
    private Date toDate;
    private Integer fromPrice;
    private Integer toPrice;
    private String orderBy;
    private Integer itemPerPage;
    private Integer page;
}

