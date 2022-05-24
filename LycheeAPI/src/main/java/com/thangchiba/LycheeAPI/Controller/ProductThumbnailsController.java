package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Model.ProductThumbnail;
import com.thangchiba.LycheeAPI.Service.ProductThumbnailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ProductThumbnailsController {
    @Autowired
    ProductThumbnailsService productThumbnailsService;

    @GetMapping("/product-thumbnails")
    @CrossOrigin
    public ResponseEntity<List<ProductThumbnail>> GetAllProductThumbnails(@RequestParam(required = false) String categoryId) {
        List<ProductThumbnail> result;
        if (categoryId != null) {
            result = productThumbnailsService.getProductThumbnails(categoryId);
        } else {
            result = productThumbnailsService.getProductThumbnails();
        }
        return ResponseEntity.ok(result);
    }
}
