/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avion.avion.DAO;

import com.avion.avion.model.Login;
import com.avion.avion.model.Token;

/**
 *
 * @author tsotsoa
 */
public interface LoginDAO {

    public void inscription(Login log);

    public Token Login(Login login);
}
