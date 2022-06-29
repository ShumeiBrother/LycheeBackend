package com.thangchiba.LycheeAPI.Controller;
import com.thangchiba.LycheeAPI.Request.Customers.CreateCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.DeleteCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.GetCustomerInfoRequest;
import com.thangchiba.LycheeAPI.Request.Customers.UpdateCustomerInfoRequest;
import com.thangchiba.LycheeAPI.Response.Customers.CreateCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.DeleteCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.GetCustomerInfoResponse;
import com.thangchiba.LycheeAPI.Response.Customers.UpdateCustomerInfoResponse;
import com.thangchiba.LycheeAPI.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<GetCustomerInfoResponse> GetCustomerInfo(@Valid @RequestBody GetCustomerInfoRequest request)throws Exception{
        GetCustomerInfoResponse result;
        result = customerService.getCustomerInfo(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> CreateCustomer(@Valid @RequestBody CreateCustomerRequest request)throws Exception{
        CreateCustomerResponse result;
        result = customerService.createCustomer(request);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<DeleteCustomerResponse> DeleteCustomer(@Valid @RequestBody DeleteCustomerRequest request)throws Exception{
        DeleteCustomerResponse result;
        result = customerService.deleteCustomer(request);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<UpdateCustomerInfoResponse> UpdateCustomerInfo(@Valid @RequestBody UpdateCustomerInfoRequest request)throws Exception{
        UpdateCustomerInfoResponse result;
        result = customerService.updateCustomerInfo(request);
        return ResponseEntity.ok(result);
    }

}
