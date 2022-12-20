/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avion.avion.controller;

import com.avion.avion.repository.*;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;
import com.avion.avion.model.*;

/**
 *
 * @author tsotsoa
 */
@Controller
public class LoginController {
    @Autowired
    private LoginRepository rep;

    private Data data = new Data();

    @CrossOrigin
    @RequestMapping(value = "/inscription", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ArrayList<Data> Inscription(HttpServletRequest request) {
        Login retour = new Login();
        retour.setLogin(request.getParameter("login"));
        retour.setMdp(request.getParameter("mdp"));
        rep.inscription(retour);
        retour.setMdp(retour.SHA1());
        ArrayList<Login> login = new ArrayList<>();
        login.add(retour);
        ArrayList<Data> __data = new ArrayList<>();
        data.setData(login);
        __data.add(data);
        return __data;
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ArrayList<Data> Login(HttpServletRequest request) {
        Login retour = new Login();
        retour.setLogin(request.getParameter("login"));
        retour.setMdp(request.getParameter("mdp"));
        Token token = rep.Login(retour);
        ArrayList<Token> TokenRes = new ArrayList<>();
        TokenRes.add(token);
        ArrayList<Data> __data = new ArrayList<>();
        data.setData(TokenRes);
        __data.add(data);
        return __data;
    }

    @CrossOrigin
    @RequestMapping(value = "/TESTEXP", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ArrayList<Data> TestEXP(HttpServletRequest request) {
        ArrayList<Data> __data = new ArrayList<>();
        ArrayList data = new ArrayList<>();
        String token = request.getParameter("TESTEXP");
        try {
            Date EXP = new Token().getDateEXP(token);
            data.add(EXP);
            this.data.setData(data);
        } catch (Exception ex) {
            String erreur = "TOKEN Expiré";
            data.add(erreur);
            this.data.setData(data);
        }
        __data.add(this.data);
        return __data;
    }

}
