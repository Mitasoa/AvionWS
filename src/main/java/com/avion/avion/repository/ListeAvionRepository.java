package com.avion.avion.repository;

import com.avion.avion.DAO.ListeAvionDAO;
import com.avion.avion.model.DetailAvion;
import com.avion.avion.model.ListeAvion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ListeAvionRepository implements ListeAvionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<ListeAvion> ListeAvion() {
        String sql = "SELECT id,immatriculation,nom,capacite FROM avion";
        return (ArrayList<ListeAvion>) jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<ListeAvion>(ListeAvion.class));
    }

    @Override
    public ArrayList<ListeAvion> Recherche(String mot) {
        String sql = "SELECT id,immatriculation,nom,capacite from avion WHERE immatriculation ILIKE '%"+mot+"%' OR nom ILIKE '%"+mot+"%'";
        System.out.println(sql);
        return (ArrayList<ListeAvion>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<ListeAvion>(ListeAvion.class));
    }
}
