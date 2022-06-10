package com.thangchiba.LycheeAPI.Request.Customers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class CreateCustomerRequest {
    private String customerName;
    private String phoneNumber;
    private String mailAddress;
    private String zipCode;
    private String prefecture;
    private String address;
    @Nullable
    private String facebook;
    private String password;

    public String getPassword() {
        return password;
    }
}
