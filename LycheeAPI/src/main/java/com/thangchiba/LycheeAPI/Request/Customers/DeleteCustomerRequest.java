package com.thangchiba.LycheeAPI.Request.Customers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class DeleteCustomerRequest {
    private String customerId;
}
