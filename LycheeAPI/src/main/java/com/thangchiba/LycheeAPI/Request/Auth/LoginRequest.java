package com.thangchiba.LycheeAPI.Request.Auth;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class LoginRequest {
    private String mailAddress;
    private String password;
}
