package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.Customers.CreateCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.DeleteCustomerRequest;
import com.thangchiba.LycheeAPI.Response.Customers.CreateCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.DeleteCustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class CustomerService extends BaseService<CreateCustomerResponse> {
    @Autowired
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        RowMapper<CreateCustomerResponse> rowMapper = new BeanPropertyRowMapper<>(CreateCustomerResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        String encodedPassword = passwordEncoder().encode(request.getPassword());
        String normalCustomerTypeCode = "15000001";
        String SQL_CREATE_CUSTOMER = "INSERT INTO \n" +
                "M_CUSTOMER (\n" +
                "CUSTOMER_ID,\n" +
                "CUSTOMER_NAME,\n" +
                "PHONE_NUMBER,\n" +
                "MAIL_ADDRESS,\n" +
                "ZIP_CODE,\n" +
                "PREFECTURE,\n" +
                "ADDRESS,\n" +
                "CUSTOMER_TYPE_ID,\n" +
                "FACEBOOK,\n" +
                "CREATE_DATE,\n" +
                "PASSWORD,\n" +
                "DEL_FLG\n" +
                ") VALUES (\n" +
                "NEXTVAL('customer_id_seq'),\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?\n" +
                ") RETURNING CUSTOMER_ID ";

        params.add(request.getCustomerName());
        params.add(request.getPhoneNumber());
        params.add(request.getMailAddress());
        params.add(request.getZipCode());
        params.add(request.getPrefecture());
        params.add(request.getAddress());
        params.add(normalCustomerTypeCode);
        params.add(request.getFacebook());
        params.add(new Date());
        params.add(encodedPassword);
        params.add(false);
        try {
            CreateCustomerResponse result = jdbcTemplate.queryForObject(SQL_CREATE_CUSTOMER, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request){
        RowMapper<DeleteCustomerResponse> rowMapper = new BeanPropertyRowMapper<>(DeleteCustomerResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        String SQL_DELETE_CUSTOMER = "UPDATE\n" +
                "M_CUSTOMER\n" +
                "SET\n" +
                "DEL_FLG = TRUE\n" +
                "WHERE\n" +
                "CUSTOMER_ID = ? RETURNING CUSTOMER_ID";
        params.add(request.getCustomerId());
        try {
            DeleteCustomerResponse result = jdbcTemplate.queryForObject(SQL_DELETE_CUSTOMER, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
