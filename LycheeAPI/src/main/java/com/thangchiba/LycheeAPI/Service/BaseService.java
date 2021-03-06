package com.thangchiba.LycheeAPI.Service;

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

    protected String PaginatingQuery(Integer itemPerPage, Integer page) {
        if (itemPerPage != null && page != null) {
            return " LIMIT " + itemPerPage + " OFFSET " + (page * itemPerPage);
        } else return "";
    }

}
