package com.avion.avion.DAO;

import com.avion.avion.model.DetailAvion;

import java.util.ArrayList;

public interface DetailAvionDAO {
    public ArrayList<DetailAvion> AllDetailAvion();
    public ArrayList<DetailAvion> DetailAvionById(int id);
    public ArrayList<DetailAvion> Recherche(String mot);
}
