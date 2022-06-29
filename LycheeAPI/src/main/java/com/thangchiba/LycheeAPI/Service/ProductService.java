package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Configuration.Exception.APIException;
import com.thangchiba.LycheeAPI.Request.Products.CreateProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.DeleteProductRequest;
import com.thangchiba.LycheeAPI.Request.Products.GetProductDetailRequest;
import com.thangchiba.LycheeAPI.Request.Products.UpdateProductRequest;
import com.thangchiba.LycheeAPI.Response.Products.CreateProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.DeleteProductResponse;
import com.thangchiba.LycheeAPI.Response.Products.GetProductDetailResponse;
import com.thangchiba.LycheeAPI.Response.Products.UpdateProductResponse;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.Date;


@Component
public class ProductService extends BaseService<GetProductDetailResponse> {

    public GetProductDetailResponse GetProductDetailInformation(GetProductDetailRequest request) throws APIException {
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
        GetProductDetailResponse result = jdbcTemplate.queryForObject(SQL_QUERY, rowMapper, params.toArray());
        if (result == null) throw new APIException("商品を見つからなかった");
        return result;
    }

    public CreateProductResponse CreateProduct(CreateProductRequest request) throws APIException {
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
                "del_flg, \n" +
                "create_date) \n" +
                "VALUES ( \n" +
                "nextval('product_id_seq'), \n" +
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
                "?) RETURNING product_id";
        ArrayList<Object> params = new ArrayList<>();
        params.add(request.getMaker());
        params.add(request.getMadeIn());
        params.add(request.getProductName());
        params.add(request.getSize());
        params.add(request.getColor());
        params.add(request.getDescription());
        params.add(request.getReceiptPrice());
        params.add(request.getPrice());
        params.add(request.getProductPoint());
        params.add(request.getWeight());
        params.add(request.getThumbnailImage());
        params.add(request.getListImage());
        params.add(request.getListCategoryId());
        params.add(request.getExpiry());
        params.add(false);
        params.add(new Date());
        try {
            CreateProductResponse result = jdbcTemplate.queryForObject(SQL_INSERT_NEW_PRODUCT, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            throw new APIException("商品を登録できなかった");
        }
    }

    public UpdateProductResponse UpdateProductResponse(UpdateProductRequest request) throws APIException {
        RowMapper<UpdateProductResponse> rowMapper = new BeanPropertyRowMapper<>(UpdateProductResponse.class);
        String SQL_UPDATE_PRODUCT = "UPDATE \n" +
                "m_product \n" +
                "SET \n" +
                "maker = ?, \n" +
                "made_in = ?, \n" +
                "product_name = ?, \n" +
                "size = ?, \n" +
                "color = ?, \n" +
                "description = ?, \n" +
                "receipt_price = ?, \n" +
                "price = ?, \n" +
                "product_point = ?, \n" +
                "weight = ?, \n" +
                "thumbnail_image = ?, \n" +
                "list_image = ?, \n" +
                "list_category_id = ?, \n" +
                "expiry = ?,\n" +
                "update_date = ? \n" +
                "WHERE product_id = ?\n" +
                "RETURNING product_id";
        ArrayList<Object> params = new ArrayList<>();
        params.add(request.getMaker());
        params.add(request.getMadeIn());
        params.add(request.getProductName());
        params.add(request.getSize());
        params.add(request.getColor());
        params.add(request.getDescription());
        params.add(request.getReceiptPrice());
        params.add(request.getPrice());
        params.add(request.getProductPoint());
        params.add(request.getWeight());
        params.add(request.getThumbnailImage());
        params.add(request.getListImage());
        params.add(request.getListCategoryId());
        params.add(request.getExpiry());
        params.add(new Date());
        params.add(request.getProductId());

        try {
            UpdateProductResponse result = jdbcTemplate.queryForObject(SQL_UPDATE_PRODUCT, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            throw new APIException("商品を更新できなかった");
        }
    }

    public DeleteProductResponse DeleteProductResponse(DeleteProductRequest request) throws APIException {
        RowMapper<DeleteProductResponse> rowMapper = new BeanPropertyRowMapper<>(DeleteProductResponse.class);
        String SQL_DELETE_PRODUCT = "update\n" +
                "M_PRODUCT\n" +
                "set \n" +
                "DEL_FLG = true\n" +
                "where\n" +
                "PRODUCT_ID = ?\n" +
                "returning PRODUCT_ID";
        ArrayList<Object> params = new ArrayList<>();
        params.add(request.getProductId());
        try {
            DeleteProductResponse result = jdbcTemplate.queryForObject(SQL_DELETE_PRODUCT, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            throw new APIException("商品を削除できなかった");
        }
    }
}
