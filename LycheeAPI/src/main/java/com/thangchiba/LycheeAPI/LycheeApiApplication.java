package com.thangchiba.LycheeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication

public class LycheeApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LycheeApiApplication.class, args);
    }

}
