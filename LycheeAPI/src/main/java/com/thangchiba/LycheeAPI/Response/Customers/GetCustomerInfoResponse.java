package com.thangchiba.LycheeAPI.Response.Customers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Date;

@Getter
@Setter
public class GetCustomerInfoResponse {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String mailAddress;
    private String zipCode;
    private String prefecture;
    private String address;
    private Integer countBuyTime;
    private Integer totalMoneyUsed;
    private Integer customerPoint;
    private String customerTypeId;
    private String facebook;
    private String cart;
    private Date lastLogin;
    private Date lastUpdateProfile;
}
