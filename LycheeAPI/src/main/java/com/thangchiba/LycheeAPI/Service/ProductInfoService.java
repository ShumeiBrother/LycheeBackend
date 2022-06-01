package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.GetProductDetailInformationRequest;
import com.thangchiba.LycheeAPI.Response.GetProductDetailInformationResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;


@Component
public class ProductInfoService extends BaseService<GetProductDetailInformationResponse> {
    protected RowMapper<GetProductDetailInformationResponse> rowMapper = new BeanPropertyRowMapper<>(GetProductDetailInformationResponse.class);

    public GetProductDetailInformationResponse getProductDetailInformation(GetProductDetailInformationRequest request){
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
            GetProductDetailInformationResponse result = jdbcTemplate.queryForObject(SQL_QUERY, rowMapper, params.toArray());
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
