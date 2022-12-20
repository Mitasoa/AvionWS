package com.avion.avion.controller;

import com.avion.avion.model.Data;
import com.avion.avion.model.Erreur;
import com.avion.avion.model.ListeAvionAssurance;
import com.avion.avion.repository.ListeAvionAssuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class ListeAvionAssuranceController {
    @Autowired
    private ListeAvionAssuranceRepository rep;
    private Data data = new Data();
    ArrayList error = new ArrayList<>();
    String message;
    int status;

    // Select
    @RequestMapping(value = "/assurances/{mois}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> AssuranceExpire(HttpServletRequest request, @PathVariable(value = "mois") Integer mois) {
        ArrayList<Data> __data = new ArrayList<>();
        try {
            ArrayList<ListeAvionAssurance> assurances = rep.AssuranceExpire(mois);
            data.setData(assurances);
            System.out.println(assurances.size());
        } catch (Exception ex) {
            status = 500;
            message = "Error d'acces base de donnee detecter";
            Erreur __error = new Erreur(status, message);
            error.add(__error);
        }
        __data.add(data);
        return __data;
    }
}
