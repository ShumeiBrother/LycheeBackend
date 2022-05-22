package com.thangchiba.LycheeAPI.Controller;

import com.thangchiba.LycheeAPI.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ProductsController {
    @GetMapping("/product-thumbnails")
    @CrossOrigin
    public ResponseEntity<Product> GetProducts(){
        Product product = new Product("1","Thitbo","Mota",123l,"quanque.jpeg","123");
        return ResponseEntity.ok(product);
    }
}
