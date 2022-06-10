package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.Customers.CreateCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.DeleteCustomerRequest;
import com.thangchiba.LycheeAPI.Request.Customers.GetCustomerInfoRequest;
import com.thangchiba.LycheeAPI.Request.Customers.UpdateCustomerInfoRequest;
import com.thangchiba.LycheeAPI.Response.Customers.CreateCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.DeleteCustomerResponse;
import com.thangchiba.LycheeAPI.Response.Customers.GetCustomerInfoResponse;
import com.thangchiba.LycheeAPI.Response.Customers.UpdateCustomerInfoResponse;
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

    public DeleteCustomerResponse deleteCustomer(DeleteCustomerRequest request) {
        RowMapper<DeleteCustomerResponse> rowMapper = new BeanPropertyRowMapper<>(DeleteCustomerResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        String SQL_DELETE_CUSTOMER = "UPDATE\n" +
                "\tM_CUSTOMER\n" +
                "SET\n" +
                "\tDEL_FLG = TRUE\n" +
                "WHERE\n" +
                "\tCUSTOMER_ID = ?\n" +
                "\tAND DEL_FLG IS FALSE RETURNING CUSTOMER_ID\n";
        params.add(request.getCustomerId());
        try {
            DeleteCustomerResponse result = jdbcTemplate.queryForObject(SQL_DELETE_CUSTOMER, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UpdateCustomerInfoResponse updateCustomerInfo(UpdateCustomerInfoRequest request) {
        RowMapper<UpdateCustomerInfoResponse> rowMapper = new BeanPropertyRowMapper<>(UpdateCustomerInfoResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        String SQL_UPDATE_CUSTOMER_INFO = "UPDATE\n" +
                "\tM_CUSTOMER\n" +
                "SET\n" +
                "\tCUSTOMER_NAME = ?,\n" +
                "\tPHONE_NUMBER = ?,\n" +
                "\tMAIL_ADDRESS = ?,\n" +
                "\tZIP_CODE = ?,\n" +
                "\tPREFECTURE = ?,\n" +
                "\tADDRESS = ?,\n" +
                "\tFACEBOOK = ?,\n" +
                "\tLAST_UPDATE_PROFILE = ?,\n" +
                "\tUPDATE_DATE = ?\n" +
                "WHERE\n" +
                "\tCUSTOMER_ID = ?\n" +
                "\tAND DEL_FLG IS FALSE RETURNING CUSTOMER_ID\n";
        params.add(request.getCustomerName());
        params.add(request.getPhoneNumber());
        params.add(request.getMailAddress());
        params.add(request.getZipCode());
        params.add(request.getPrefecture());
        params.add(request.getAddress());
        params.add(request.getFacebook());
        params.add(new Date());
        params.add(new Date());
        params.add(request.getCustomerId());
        try {
            UpdateCustomerInfoResponse result = jdbcTemplate.queryForObject(SQL_UPDATE_CUSTOMER_INFO, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public GetCustomerInfoResponse getCustomerInfo(GetCustomerInfoRequest request) {
        RowMapper<GetCustomerInfoResponse> rowMapper = new BeanPropertyRowMapper<>(GetCustomerInfoResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        String SQL_GET_CUSTOMER_INFO = "SELECT\n" +
                "\tCUSTOMER_ID,\n" +
                "\tCUSTOMER_NAME,\n" +
                "\tPHONE_NUMBER,\n" +
                "\tMAIL_ADDRESS,\n" +
                "\tZIP_CODE,\n" +
                "\tPREFECTURE,\n" +
                "\tADDRESS,\n" +
                "\tCOUNT_BUY_TIME,\n" +
                "\tTOTAL_MONEY_USED,\n" +
                "\tCUSTOMER_POINT,\n" +
                "\tCUSTOMER_TYPE_ID,\n" +
                "\tFACEBOOK,\n" +
                "\tCART,\n" +
                "\tLAST_LOGIN,\n" +
                "\tLAST_UPDATE_PROFILE\n" +
                "FROM\n" +
                "\tM_CUSTOMER MC\n" +
                "WHERE\n" +
                "\tCUSTOMER_ID = ?\n" +
                "\tAND DEL_FLG IS FALSE";
        params.add(request.getCustomerId());
        try {
            GetCustomerInfoResponse result = jdbcTemplate.queryForObject(SQL_GET_CUSTOMER_INFO, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
