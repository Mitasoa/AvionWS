package com.avion.avion.model;

public class ListeAvion {
    private int id;
    String immatriculation;
    String nom;
    int capacite;

    public ListeAvion() {
    }

    public ListeAvion(int id, String immatriculation, String nom, int capacite) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nom = nom;
        this.capacite = capacite;
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
}
