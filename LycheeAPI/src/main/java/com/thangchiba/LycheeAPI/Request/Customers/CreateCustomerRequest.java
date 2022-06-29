package com.thangchiba.LycheeAPI.Request.Customers;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateCustomerRequest {
    private String customerName;
    private String phoneNumber;
    @NotNull
    @Pattern(regexp=".+@.+\\.[a-z]+", message="Invalid email address!")
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
