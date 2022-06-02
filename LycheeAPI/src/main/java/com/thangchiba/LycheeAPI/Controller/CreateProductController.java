package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.CreateProductRequest;
import com.thangchiba.LycheeAPI.Response.CreateProductResponse;
import com.thangchiba.LycheeAPI.Service.CreateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CreateProductController {
    @Autowired
    CreateProductService createProductService;

    @PostMapping("/product-create")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        CreateProductResponse result;
        result = createProductService.createProduct(request);
        return ResponseEntity.ok(result);
    }
}
