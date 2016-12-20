package com.autoclinic.MODEL;

import java.io.Serializable;

/**
 * Created by SEYDOU BERTHE on 25/06/2016.
 */
public class Employer implements Serializable{
    private int id;
    private String nom;
    private String prenom ;
    private String dateDN;
    private String CIN;
    private String tlf ;
    private String fonction ;

    public Employer(String nom, String prenom, String dateDN, String CIN, String tlf,String fonction){
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.dateDN = dateDN;
        this.tlf = tlf;
        this.fonction = fonction;

    }
    public Employer(){}
    public Employer(String nom){
        super();
        this.nom = nom;
        //this.type = type;
    }
    public Employer(String nom,String fonction){
        super();
        this.nom = nom;
        this.fonction = fonction;
    }

    public int  getId(){ return id;}

    public void setId(int id){
        this.id = id;
    }

    public String getFonction() {
        return fonction;
    }

    public void setType(String fonction) {
        this.fonction = fonction;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateDN() {
        return dateDN;
    }

    public void setDateDN(String dateDN) {
        this.dateDN = dateDN;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String cIN) {
        CIN = cIN;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }



}

