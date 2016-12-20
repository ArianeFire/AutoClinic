package com.autoclinic.MODEL;

/**
 * Created by SEYDOU BERTHE on 04/05/2016.
 */
public class Assurance1 {

    private String nom;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String date;
    private int id;

    public Client getmClient() {
        return mClient;
    }

    public void setmClient(Client mClient) {
        this.mClient = mClient;
    }

    public Vehicule1 getVehicule1() {
        return vehicule1;
    }

    public void setVehicule1(Vehicule1 vehicule1) {
        this.vehicule1 = vehicule1;
    }

    private Client mClient;
    private Vehicule1 vehicule1;

    public Assurance1(){
        mClient = new Client();
        vehicule1 = new Vehicule1();
    }

    public String getNom(){ return nom;}
    public int getId(){return id;}
    public void setNom(String nom){ this.nom = nom;}
    public void setId(int id){ this.id = id;}
}
