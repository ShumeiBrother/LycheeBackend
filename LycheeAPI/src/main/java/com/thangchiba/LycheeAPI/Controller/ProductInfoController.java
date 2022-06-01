package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.GetProductDetailInformationRequest;
import com.thangchiba.LycheeAPI.Response.GetProductDetailInformationResponse;
import com.thangchiba.LycheeAPI.Request.GetProductThumbnailsRequest;
import com.thangchiba.LycheeAPI.Response.GetProductThumbnailsResponse;
import com.thangchiba.LycheeAPI.Service.ProductInfoService;
import com.thangchiba.LycheeAPI.Service.ProductThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProductInfoController {
    @Autowired
    ProductInfoService productInfoService;

    @GetMapping("/product")
    @CrossOrigin
    public ResponseEntity<GetProductDetailInformationResponse> GetProductDetailInformation(GetProductDetailInformationRequest request) {
        GetProductDetailInformationResponse result;
        result = productInfoService.getProductDetailInformation(request);
        return ResponseEntity.ok(result);
    }
}
