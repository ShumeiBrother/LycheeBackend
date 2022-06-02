package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Request.ProductThumbnails.GetProductThumbnailsRequest;
import com.thangchiba.LycheeAPI.Response.ProductThumbnails.GetProductThumbnailsResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductThumbnailsService extends BaseService<GetProductThumbnailsResponse> {
    protected RowMapper<GetProductThumbnailsResponse> rowMapper = new BeanPropertyRowMapper<>(GetProductThumbnailsResponse.class);

    public List<GetProductThumbnailsResponse> getProductThumbnails(GetProductThumbnailsRequest request) {
        ArrayList<Object> params = new ArrayList<Object>();
        String WHERE_CLAUSE = "";
        if (request.getCategoryId() != null) {
            WHERE_CLAUSE += " AND ? = ANY(MP.LIST_CATEGORY_ID) ";
            params.add(request.getCategoryId());
        }
        String PAGINATING_QUERY = PaginatingQuery(request.getItemPerPage(), request.getPage());
        String SQL_QUERY = "SELECT \n" +
                "mp.product_id,\n" +
                "mp.product_name,\n" +
                "mp.size,\n" +
                "mp.color,\n" +
                "mp.description,\n" +
                "mp.price,\n" +
                "mp.product_point,\n" +
                "mp.thumbnail_image,\n" +
                "array_agg(mc.category_name)::character varying[] as LIST_CATEGORY_NAME\n" +
                "FROM M_PRODUCT AS MP \n" +
                "LEFT JOIN M_CATEGORY AS MC\n" +
                "ON mc.category_id = ANY(mp.list_category_id)\n" +
                "WHERE MP.DEL_FLG IS FALSE\n" +
                WHERE_CLAUSE +
                "GROUP BY product_id " +
                PAGINATING_QUERY;
        try {
            List<GetProductThumbnailsResponse> result = jdbcTemplate.query(SQL_QUERY, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
