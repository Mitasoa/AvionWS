package com.avion.avion.controller;

import com.avion.avion.model.Data;
import com.avion.avion.model.DetailAvion;
import com.avion.avion.model.Erreur;
import com.avion.avion.repository.DetailAvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class DetailAvionController{
    @Autowired
    private DetailAvionRepository rep;

    private Data data = new Data();
    ArrayList error = new ArrayList<>();
    String message;
    int status;

    @RequestMapping(value = "/DetailAvions", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> DetailAvion() {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<DetailAvion> detailAvions = rep.AllDetailAvion();
            data.setData(detailAvions);
            System.out.println(detailAvions.size());
        } catch (Exception ex) {
            ex.printStackTrace();
            status = 500;
            message = "Error d'acces base de donnee detecter";
            Erreur __error = new Erreur(status, message);
            error.add(__error);
        }
        __data.add(data);
        return __data;
    }

    @RequestMapping(value = "/DetailAvions/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> DetailAvionByID(@PathVariable(value = "id") Integer id) {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<DetailAvion> detailAvions = rep.DetailAvionById(id);
            data.setData(detailAvions);
            System.out.println(detailAvions.size());
        } catch (Exception ex) {
            status = 500;
            message = "Error d'acces base de donnee detecter";
            Erreur __error = new Erreur(status, message);
            error.add(__error);
        }
        __data.add(data);
        return __data;
    }

    @RequestMapping(value = "/DetailAvion/recherche/{mot}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> getDetailsAvion(@PathVariable(value = "mot") String mot) {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<DetailAvion> detailAvions = rep.Recherche(mot);
            System.out.println(detailAvions.size());
            data.setData(detailAvions);
        } catch (Exception ex) {
            status = 500;
            message = "Error d'acces base de donnee detecter";
            Erreur __error = new Erreur(status, message);
            error.add(__error);
            ex.printStackTrace();
        }
        __data.add(data);
        return __data;
    }
}
