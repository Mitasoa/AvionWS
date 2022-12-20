package com.avion.avion.controller;

import com.avion.avion.model.Data;
import com.avion.avion.model.DetailAvion;
import com.avion.avion.model.Erreur;
import com.avion.avion.model.ListeAvion;
import com.avion.avion.repository.ListeAvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ListeAvionController {

    @Autowired
    private ListeAvionRepository rep;

    private Data data = new Data();
    ArrayList error = new ArrayList<>();
    String message;
    int status;

    @RequestMapping(value = "/ListeAvions", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> ListeAvion() {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<ListeAvion> listeAvions = rep.ListeAvion();
            data.setData(listeAvions);
            System.out.println(listeAvions.size());
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

    @RequestMapping(value = "/ListeAvion/recherche/{mot}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> getDetailsAvion(@PathVariable(value = "mot") String mot) {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<ListeAvion> listeAvions = rep.Recherche(mot);
            System.out.println(listeAvions.size());
            data.setData(listeAvions);
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
