package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.Products.CreateProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.GetProductDetailRequest;
import com.thangchiba.LycheeAPI.Response.Products.CreateProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.GetProductDetailResponse;
import com.thangchiba.LycheeAPI.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    @CrossOrigin
    public ResponseEntity<GetProductDetailResponse> GetProductDetailInformation(GetProductDetailRequest request) {
        GetProductDetailResponse result;
        result = productService.getProductDetailInformation(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        CreateProductResponse result;
        result = productService.createProduct(request);
        return ResponseEntity.ok(result);
    }
}
