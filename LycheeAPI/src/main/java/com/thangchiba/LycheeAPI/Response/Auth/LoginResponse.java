package com.thangchiba.LycheeAPI.Response.Auth;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResponse {
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
