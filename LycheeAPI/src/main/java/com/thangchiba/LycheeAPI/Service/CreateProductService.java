package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.CreateProductRequest;
import com.thangchiba.LycheeAPI.Response.CreateProductResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;

@Component
public class CreateProductService extends BaseService<CreateProductResponse> {
    protected RowMapper<CreateProductResponse> rowMapper = new BeanPropertyRowMapper<>(CreateProductResponse.class);

    public CreateProductResponse createProduct(CreateProductRequest request) {

        String SQL_INSERT_NEW_PRODUCT = "INSERT INTO \n" +
                "m_product (product_id, \n" +
                "maker, \n" +
                "made_in, \n" +
                "product_name, \n" +
                "size, \n" +
                "color, \n" +
                "description, \n" +
                "receipt_price, \n" +
                "price, \n" +
                "product_point, \n" +
                "weight, \n" +
                "thumbnail_image, \n" +
                "list_image, \n" +
                "list_category_id, \n" +
                "expiry, \n" +
                "create_date) \n" +
                "VALUES ( \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "?, \n" +
                "2022-06-02)";
        String SQL_QUERY = "SELECT product_id FROM m_product AS mp WHERE product_id = ?";
        try {
            jdbcTemplate.update(SQL_INSERT_NEW_PRODUCT, request.getProductId(), request.getMaker(), request.getMadeIn(),
                    request.getProductName(), request.getSize(), request.getColor(), request.getDescription(),
                    request.getReceiptPrice(), request.getPrice(), request.getProductPoint(), request.getWeight(),
                    request.getThumbnailImage(), request.getListImage(),request.getListCategoryId(), request.getExpiry());
            CreateProductResponse result = jdbcTemplate.queryForObject(SQL_QUERY, rowMapper, request.getProductId());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
