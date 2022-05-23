package com.thangchiba.LycheeAPI.Service;

import com.thangchiba.LycheeAPI.Model.ProductThumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class BaseService<T> {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

}
