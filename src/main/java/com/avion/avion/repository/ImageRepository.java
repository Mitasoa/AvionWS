package com.avion.avion.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void UpdateImage(String image, int Avionid) {
        String sql = "UPDATE ImageAvion set image = ? WHERE Avionid = ?";
        jdbcTemplate.update(sql, image, Avionid);
    }

}
