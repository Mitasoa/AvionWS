package com.avion.avion.repository;

import com.avion.avion.DAO.ListeAvionAssuranceDAO;
import com.avion.avion.model.ListeAvionAssurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Repository
public class ListeAvionAssuranceRepository implements ListeAvionAssuranceDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList<ListeAvionAssurance> AssuranceExpire(int mois) {
        String sql = "SELECT*FROM assuranceexpire WHERE dateexpiration>=? and dateexpiration<=?";
        LocalDate now = LocalDate.now();
        return (ArrayList<ListeAvionAssurance>) jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<ListeAvionAssurance>(ListeAvionAssurance.class),now,now.plusMonths(mois));
    }
}
