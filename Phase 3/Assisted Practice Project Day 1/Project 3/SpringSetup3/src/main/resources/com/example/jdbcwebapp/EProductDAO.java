package com.example.jdbcwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EProductDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EProduct> getAllProducts() {
        String sql = "SELECT * FROM eproduct";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            EProduct product = new EProduct();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));
            return product;
        });
    }
}
