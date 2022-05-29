package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Entity.Product;
import com.thangchiba.LycheeAPI.Model.ProductThumbnail;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductThumbnailsService extends BaseService<ProductThumbnail> {
    protected RowMapper rowMapper = new BeanPropertyRowMapper<ProductThumbnail>(ProductThumbnail.class);

    private static String GET_PRODUCTS_THUMBNAIL = new StringBuilder()
            .append("SELECT * " +
                    "FROM M_PRODUCT ").toString();

    public List<ProductThumbnail> getProductThumbnails() {
        try {
            List<ProductThumbnail> result = jdbcTemplate.query(GET_PRODUCTS_THUMBNAIL, rowMapper);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String GET_PRODUCTS_THUMBNAIL_BY_CATEGORY_ID = new StringBuilder()
            .append("SELECT * " +
                    "FROM M_PRODUCT " +
                    "WHERE ? = ANY(LIST_CATEGORY_ID) " +
                    "AND MADE_IN = ?").toString();

    public List<ProductThumbnail> getProductThumbnails(String categoryId,String madeIn) {
        try {
            ArrayList<Object> params = new ArrayList<>();
            params.add(categoryId);
            params.add(madeIn);
            List<ProductThumbnail> result = jdbcTemplate.query(GET_PRODUCTS_THUMBNAIL_BY_CATEGORY_ID, rowMapper, params.toArray());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
