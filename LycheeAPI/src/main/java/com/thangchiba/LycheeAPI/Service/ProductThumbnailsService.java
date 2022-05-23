package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Model.ProductThumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductThumbnailsService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductThumbnailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<ProductThumbnail> rowMapperProductThumbnail = new BeanPropertyRowMapper<ProductThumbnail>(
            ProductThumbnail.class);

    private static String GET_PRODUCTS_THUMBNAIL = new StringBuilder()
            .append("SELECT * FROM m_product ").toString();

    public List<ProductThumbnail> searchEarningInformation(Integer page, Integer quantity) {
        try {
            ArrayList<Object> param = new ArrayList<Object>();
            //param[0] = "%" + "keyword" + "%";
            param.add(page);
            param.add(quantity);
            // SQL実行
            List<ProductThumbnail> result = jdbcTemplate.query(GET_PRODUCTS_THUMBNAIL, rowMapperProductThumbnail);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
