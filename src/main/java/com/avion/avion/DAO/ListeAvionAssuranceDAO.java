package com.avion.avion.DAO;

import com.avion.avion.model.ListeAvionAssurance;

import java.util.ArrayList;

public interface ListeAvionAssuranceDAO {
    public ArrayList<ListeAvionAssurance> AssuranceExpire(int mois);
}
