package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.Products.CreateProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.GetProductDetailRequest;
import com.thangchiba.LycheeAPI.Response.Products.CreateProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.GetProductDetailResponse;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;


@Component
public class ProductService extends BaseService<GetProductDetailResponse> {

    public GetProductDetailResponse getProductDetailInformation(GetProductDetailRequest request){
        RowMapper<GetProductDetailResponse> rowMapper = new BeanPropertyRowMapper<>(GetProductDetailResponse.class);
        ArrayList<Object> params = new ArrayList<>();
        params.add(request.getProductId());
        String SQL_QUERY = "SELECT \n" +
                "mp.product_id,\n" +
                "mp.maker,\n" +
                "mp.made_in,\n" +
                "mp.product_name,\n" +
                "mp.size,\n" +
                "mp.color,\n" +
                "mp.description,\n" +
                "mp.receipt_price,\n" +
                "mp.price,\n" +
                "mp.product_point,\n" +
                "mp.weight,\n" +
                "mp.thumbnail_image,\n" +
                "mp.list_image,\n" +
                "array_agg(mc.category_name)::character varying as list_category_name, \n" +
                "mp.expiry \n" +
                "FROM m_product AS mp \n" +
                "LEFT JOIN m_category AS mc \n" +
                "ON mc.category_id = ANY(mp.list_category_id) \n" +
                "WHERE mp.del_flg IS FALSE AND mp.product_id = ? \n" +
                "GROUP BY mp.product_id";
        try {
            GetProductDetailResponse result = jdbcTemplate.queryForObject(SQL_QUERY, rowMapper, params.toArray());
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CreateProductResponse createProduct(CreateProductRequest request) {
        RowMapper<CreateProductResponse> rowMapper = new BeanPropertyRowMapper<>(CreateProductResponse.class);
        String SQL_INSERT_NEW_PRODUCT = "INSERT INTO \n" +
                "m_product " +
                "(product_id, \n" +
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