package com.avion.avion.model;

import java.sql.Date;

public class ListeAvionAssurance {
    private int id;
    String immatriculation;
    String nom;
    int capacite;
    Date DateExpiration;

    public ListeAvionAssurance() {
    }

    public ListeAvionAssurance(int id, String immatriculation, String nom, int capacite, Date dateExpiration) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nom = nom;
        this.capacite = capacite;
        DateExpiration = dateExpiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Date getDateExpiration() {
        return DateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        DateExpiration = dateExpiration;
    }
}
