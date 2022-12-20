package com.avion.avion.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import com.avion.avion.model.Data;
import com.avion.avion.model.Erreur;
import com.avion.avion.repository.ImageRepository;

@Controller
public class ImageController {

    @Autowired
    private ImageRepository rep;

    private Data data = new Data();
    ArrayList error = new ArrayList<>();
    ArrayList<Data> __data = new ArrayList<>();
    String message;
    int status;

    // UpdateImage
    @RequestMapping(value = "/updateImage/{AvionId}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    @CrossOrigin
    public ArrayList<Data> getImage(@RequestBody String img, @PathVariable(value = "AvionId") Integer AvionId) {
        try {
            rep.UpdateImage(img, AvionId);
            ArrayList succes = new ArrayList();
            succes.add("Mise à jour faite avec succes");
            data.setData(succes);
        } catch (Exception ex) {
            status = 500;
            message = "Une erreur s'est produite lors de la mise à jour";
            Erreur __error = new Erreur(status, message);
            error.add(__error);
        }
        __data.add(data);
        return __data;
    }

}
