package com.autoclinic.MODEL;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */

public class Vehicule {

    private int id;
    private String marque ;
    private String modele;
    private String immatriculation;
    private String numChassais;
    private String kilometrage;
    private String nivcarburant;

    public boolean isValid(){
        if(!marque.toString().equals("") &&
                !modele.toString().equals("") &&
                !immatriculation.toString().equals("") &&
                !numChassais.toString().equals("") &&
                !kilometrage.toString().equals("") &&
                !nivcarburant.toString().equals("")){
            return true;
        }
        return true;
    }

    public Vehicule(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public Vehicule(String marque, String modéle, String immatriculation, String numChassais, String kilométrage,
                    String nivcarburant) {
        super();
        this.marque = marque;
        modele = modéle;
        this.immatriculation = immatriculation;
        this.numChassais = numChassais;
        this.kilometrage = kilométrage;
        this.nivcarburant = nivcarburant;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modéle) {
        modele = modéle;
    }
    public String getImmatriculation() {
        return immatriculation;
    }
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
    public String getNumChassais() {
        return numChassais;
    }
    public void setNumChassais(String numChassais) {
        numChassais = numChassais;
    }
    public String getKilometrage() {
        return kilometrage;
    }
    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }
    public String getNivcarburant() {
        return nivcarburant;
    }
    public void setNivcarburant(String nivcarburant) {
        this.nivcarburant = nivcarburant;
    }

}
