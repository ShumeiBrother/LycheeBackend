package com.thangchiba.LycheeAPI.Controller;
import com.thangchiba.LycheeAPI.Request.Customers.CreateCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.DeleteCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.UpdateCustomerInfoRequest;
import com.thangchiba.LycheeAPI.Response.Customers.CreateCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.DeleteCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.UpdateCustomerInfoResponse;
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

    @DeleteMapping
    public ResponseEntity<DeleteCustomerResponse> DeleteCustomer(@RequestBody DeleteCustomerRequest request){
        DeleteCustomerResponse result;
        result = customerService.deleteCustomer(request);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<UpdateCustomerInfoResponse> UpdateCustomerInfo(@RequestBody UpdateCustomerInfoRequest request){
        UpdateCustomerInfoResponse result;
        result = customerService.updateCustomerInfo(request);
        return ResponseEntity.ok(result);
    }
}
