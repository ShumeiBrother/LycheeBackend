package com.thangchiba.LycheeAPI.Controller;
import com.thangchiba.LycheeAPI.Request.Customers.CreateCustomerRequest;
import com.thangchiba.LycheeAPI.Response.Customers.CreateCustomerResponse;
import com.thangchiba.LycheeAPI.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> CreateCustomer(@RequestBody CreateCustomerRequest request){
        CreateCustomerResponse result;
        result = customerService.createCustomer(request);
        return ResponseEntity.ok(result);
    }
}
