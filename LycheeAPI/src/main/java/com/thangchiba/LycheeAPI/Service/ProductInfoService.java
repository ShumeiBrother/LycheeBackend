package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.GetProductDetailInformationRequest;
import com.thangchiba.LycheeAPI.Response.GetProductDetailInformationResponse;
import com.thangchiba.LycheeAPI.Response.GetProductThumbnailsResponse;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductInfoService extends BaseService<GetProductDetailInformationResponse> {
    protected RowMapper rowMapper = new BeanPropertyRowMapper<GetProductDetailInformationResponse>(GetProductDetailInformationResponse.class);

    public List<GetProductDetailInformationResponse> getProductDetailInformation(GetProductDetailInformationRequest request){
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(request.getProductId());
        String SQL_QUERY = "SELECT \n" +
                "product_id,\n" +
                "maker,\n" +
                "made_in,\n" +
                "product_name,\n" +
                "size,\n" +
                "color,\n" +
                "description,\n" +
                "receipt_price,\n" +
                "price,\n" +
                "product_point,\n" +
                "weight,\n" +
                "thumbnail_image,\n" +
                "list_image,\n" +
                "array_agg(mc.category_name)::character varying as LIST_CATEGORY_NAME, \n" +
                "expiry \n" +
                "FROM M_PRODUCT AS MP \n" +
                "LEFT JOIN M_CATEGORY AS MC \n" +
                "ON mc.category_id = ANY(mp.list_category_id) \n" +
                "WHERE MP.DEL_FLG IS FALSE AND mp.product_id = ? \n" +
                "GROUP BY mp.product_id ";
        try {
            List<GetProductDetailInformationResponse> result = jdbcTemplate.query(SQL_QUERY, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
