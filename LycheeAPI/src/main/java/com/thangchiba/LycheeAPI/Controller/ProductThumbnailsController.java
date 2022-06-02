package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.ProductThumbnails.GetProductThumbnailsRequest;
import com.thangchiba.LycheeAPI.Response.ProductThumbnails.GetProductThumbnailsResponse;
import com.thangchiba.LycheeAPI.Service.ProductThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProductThumbnailsController {
    @Autowired
    ProductThumbnailsService productThumbnailsService;

    @GetMapping("/product-thumbnails")
    @CrossOrigin
    public ResponseEntity<List<GetProductThumbnailsResponse>> GetAllProductThumbnails(GetProductThumbnailsRequest request) {
        List<GetProductThumbnailsResponse> result;
        result = productThumbnailsService.getProductThumbnails(request);
        return ResponseEntity.ok(result);
    }
}
