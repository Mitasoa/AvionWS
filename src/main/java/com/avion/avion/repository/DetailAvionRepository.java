package com.avion.avion.repository;

import com.avion.avion.DAO.DetailAvionDAO;
import com.avion.avion.model.DetailAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DetailAvionRepository implements DetailAvionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<DetailAvion> AllDetailAvion() {
        String sql = "SELECT * FROM detailavion";
        return (ArrayList<DetailAvion>) jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<DetailAvion>(DetailAvion.class));
    }

    @Override
    public ArrayList<DetailAvion> DetailAvionById(int id) {
        String sql = "SELECT * FROM detailavion WHERE id=?";
        return (ArrayList<DetailAvion>) jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<DetailAvion>(DetailAvion.class),id);
    }

    @Override
    public ArrayList<DetailAvion> Recherche(String mot) {
        String sql = "SELECT * from detailavion WHERE immatriculation ILIKE '%"+mot+"%' OR nom ILIKE '%"+mot+"%' OR modele ILIKE '%"+mot+"%'";
        System.out.println(sql);
        return (ArrayList<DetailAvion>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<DetailAvion>(DetailAvion.class));
    }
}
