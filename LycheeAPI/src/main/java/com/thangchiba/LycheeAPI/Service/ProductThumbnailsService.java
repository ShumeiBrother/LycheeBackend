package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Entity.Product;
import com.thangchiba.LycheeAPI.Model.ProductThumbnail;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductThumbnailsService extends BaseService<ProductThumbnail>{
    private static String GET_PRODUCTS_THUMBNAIL = new StringBuilder()
            .append("SELECT * FROM m_product ").toString();
    protected RowMapper rowMapper = new BeanPropertyRowMapper<ProductThumbnail>(ProductThumbnail.class);

    public List<ProductThumbnail> searchEarningInformation(Integer page, Integer quantity) {
        try {
            ArrayList<Object> param = new ArrayList<Object>();
            //param[0] = "%" + "keyword" + "%";
            param.add(page);
            param.add(quantity);
            // SQL実行
            List<ProductThumbnail> result = jdbcTemplate.query(GET_PRODUCTS_THUMBNAIL, rowMapper);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
