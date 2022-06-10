package com.thangchiba.LycheeAPI.Request.Customers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class UpdateCustomerInfoRequest {
    @Nullable
    private String customerName;
    @Nullable
    private String phoneNumber;
    @Nullable
    private String mailAddress;
    @Nullable
    private String zipCode;
    @Nullable
    private String prefecture;
    @Nullable
    private String address;
    @Nullable
    private String facebook;
    private String customerId;
}
