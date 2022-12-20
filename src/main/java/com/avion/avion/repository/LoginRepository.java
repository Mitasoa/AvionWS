/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avion.avion.repository;

import com.avion.avion.model.*;
import com.avion.avion.DAO.*;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tsotsoa
 */
@Repository
public class LoginRepository implements LoginDAO {
     @Autowired
     private JdbcTemplate jdbcTemplate;

     public void inscription(Login login) {
          String sql = "INSERT INTO admin VALUES (DEFAULT,?,md5(?))";
          jdbcTemplate.update(sql, login.getLogin(), login.getMdp());
     }

     public Token Login(Login login) {
          Token tokenVR = null;
          String sql = "select * from admin where login=? and mdp=md5(?)";
          ArrayList<Login> result = (ArrayList<Login>) jdbcTemplate.query(sql,
                    new BeanPropertyRowMapper<Login>(Login.class), login.getLogin(), login.getMdp());
          int idutil = 0;
          if (result.size() > 0) {
               idutil = result.get(0).getId();
          }
          if (idutil != 0) {
               tokenVR = new Token().ReturnToken(idutil);
          }
          return tokenVR;
     }
}
