package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.ProductThumbnails.GetProductThumbnailsRequest;
import com.thangchiba.LycheeAPI.Response.ProductThumbnails.GetProductThumbnailsResponse;
import com.thangchiba.LycheeAPI.Service.ProductThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/product-thumbnails")
public class ProductThumbnailsController {
    @Autowired
    ProductThumbnailsService productThumbnailsService;

    @GetMapping
    public ResponseEntity<List<GetProductThumbnailsResponse>> GetAllProductThumbnails(@Valid GetProductThumbnailsRequest request) throws Exception {
        List<GetProductThumbnailsResponse> result;
        result = productThumbnailsService.getProductThumbnails(request);
        return ResponseEntity.ok(result);
    }
}
