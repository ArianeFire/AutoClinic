package com.autoclinic.MODEL;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */
//fiche

public class Fiches implements Serializable{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPieces(List<Piece> piece) {
        this.pieces = piece;
    }

    private int id;
    private String name;
    private int etat;
    private Client1 client;
    private List<Employer> employers;

    public boolean isValid(){
        if(client.isValid() && vehicule.isValid()){
            return true;
        }
        return false;
    }



    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    private List<Piece> pieces;

    public Fiches(String name, int etat, Client1 client, Vehicule vehicule, List<Piece> piece) {
        super();
        this.name = name;
        this.etat = etat;
        this.client = client;
        this.vehicule = vehicule;
        this.pieces = piece;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    private Vehicule vehicule;

    public Client1 getClient() {
        return client;
    }

    public void setClient(Client1 client) {
        this.client = client;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fiches( String name) {

        this.name = name;
        this.etat=1;
    }
    public Fiches(){
    }

    public Fiches(String fichename, Client1 client2) {
        super();
        this.name = fichename;
        this.client = client2;
    }

    public Fiches(String fichename,int etat, Client1 client2, Vehicule vehicule) {
        super();
        this.name = fichename;
        this.client = client2;
        this.vehicule = vehicule;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }



}


