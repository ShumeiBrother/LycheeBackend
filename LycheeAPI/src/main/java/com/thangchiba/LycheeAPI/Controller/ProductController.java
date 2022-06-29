package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Request.Products.CreateProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.DeleteProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.GetProductDetailRequest;
import com.thangchiba.LycheeAPI.Request.Products.UpdateProductRequest;
import com.thangchiba.LycheeAPI.Response.Products.CreateProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.DeleteProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.GetProductDetailResponse;
import com.thangchiba.LycheeAPI.Response.Products.UpdateProductResponse;
import com.thangchiba.LycheeAPI.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<GetProductDetailResponse> GetProductDetailInformation(@Valid GetProductDetailRequest request) throws Exception{
        GetProductDetailResponse result;
        result = productService.GetProductDetailInformation(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> CreateProduct(@Valid @RequestBody CreateProductRequest request) throws Exception{
        CreateProductResponse result;
        result = productService.CreateProduct(request);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> UpdateProductInfo(@Valid @RequestBody UpdateProductRequest request) throws Exception{
        UpdateProductResponse result;
        result = productService.UpdateProductResponse(request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> DeleteProduct(@Valid @RequestBody DeleteProductRequest request) throws Exception{
        DeleteProductResponse result;
        result = productService.DeleteProductResponse(request);
        return ResponseEntity.ok(result);
    }
}
