package com.autoclinic.MODEL;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */
import java.io.Serializable;


public class fiche implements Serializable{

    private int id;
    private String name;
    private String Etat;
    private Assurance ass;
    private Vehicule vehicule ;
    private Client client;



    public fiche(String name, Assurance ass) {
        super();
        this.name = name;
        this.ass = ass;
    }
    public fiche(String ficheName, Assurance assurance, Vehicule vehicule, Client client, String etat) {
        super();
        this.id = id;
        this.name = name;
        Etat = etat;
        this.ass = ass;
        this.vehicule = this.vehicule;
        this.client = client;

    }

    public String getEtat() {
        return Etat;
    }
    public void setEtat(String etat) {
        Etat = etat;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public Vehicule getVehicule() {
        return vehicule;
    }
    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Assurance getAss() {
        return ass;
    }
    public void setAss(Assurance ass) {
        this.ass = ass;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public fiche(){
    }
    public fiche(String etat2) {
        this.Etat=etat2;
    }

}

