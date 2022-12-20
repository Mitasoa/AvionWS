package com.avion.avion.DAO;

import com.avion.avion.model.DetailAvion;
import com.avion.avion.model.ListeAvion;

import java.util.ArrayList;

public interface ListeAvionDAO {
    public ArrayList<ListeAvion> ListeAvion();
    public ArrayList<ListeAvion> Recherche(String mot);
}
