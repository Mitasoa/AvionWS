package com.avion.avion.model;

public class DetailAvion {
    private int id;
    String immatriculation;
    String nom;
    int capacite;
    String description;
    int kerosene;
    String modele;
    String image;
    float Kilometrage;

    public DetailAvion() {
    }

    public DetailAvion(int id, String immatriculation, String nom, int capacite, String description, int kerosene, String modele, String image, float kilometrage) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.nom = nom;
        this.capacite = capacite;
        this.description = description;
        this.kerosene = kerosene;
        this.modele = modele;
        this.image = image;
        Kilometrage = kilometrage;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKerosene() {
        return kerosene;
    }

    public void setKerosene(int kerosene) {
        this.kerosene = kerosene;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getKilometrage() {
        return Kilometrage;
    }

    public void setKilometrage(float kilometrage) {
        Kilometrage = kilometrage;
    }
}
