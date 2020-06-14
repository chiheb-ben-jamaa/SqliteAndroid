package com.m.sqliteandroid.Model;

public class Produit {

    private int id;
    private String nom;
    private int code_a_barre;
    private int stock;
    private String categorie;


    public Produit( String nom, int code_a_barre, int stock, String categorie) {

        this.nom = nom;
        this.code_a_barre = code_a_barre;
        this.stock = stock;
        this.categorie = categorie;
    }



    public Produit() {
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCode_a_barre() {
        return code_a_barre;
    }

    public void setCode_a_barre(int code_a_barre) {
        this.code_a_barre = code_a_barre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }




}
