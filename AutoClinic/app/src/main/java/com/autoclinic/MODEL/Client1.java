package com.autoclinic.MODEL;

import java.io.Serializable;

/**
 * Created by SEYDOU BERTHE on 21/06/2016.
 */
public class Client1 implements Serializable{

    private int id;

    private String receptionle;
    private String noms;
    private String adresse;
    private String telBureau;
    private String telMobile;
    private String fax;
    private String nomsuser;
    private String tel;

    public boolean isValid(){
        if(!receptionle.toString().equals("") &&
                !noms.toString().equals("") &&
                !adresse.toString().equals("") &&
                !telBureau.toString().equals("") &&
                !telMobile.toString().equals("") &&
                !fax.toString().equals("") &&
                !nomsuser.toString().equals("") &&
                !tel.toString().equals("")
                ){
            return true;
        }

        return false;
    }

    public Client1(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNoms() {
        return noms;
    }
    public void setNoms(String noms) {
        this.noms = noms;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getReceptionle() {
        return receptionle;
    }


    public void setReceptionle(String receptionle) {
        this.receptionle = receptionle;
    }


    public String getTelBureau() {
        return telBureau;
    }


    public void setTelBureau(String telBureau) {
        this.telBureau = telBureau;
    }


    public String getTelMobile() {
        return telMobile;
    }


    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }


    public String getFax() {
        return fax;
    }


    public void setFax(String fax) {
        this.fax = fax;
    }


    public String getNomsuser() {
        return nomsuser;
    }


    public void setNomsuser(String nomsuser) {
        this.nomsuser = nomsuser;
    }


    public String getTel() {
        return tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    public Client1(String receptionle, String noms, String adresse, String telBureau, String telMobile, String fax,
                  String nomsuser, String tel) {
        super();
        this.receptionle = receptionle;
        this.noms = noms;
        this.adresse = adresse;
        this.telBureau = telBureau;
        this.telMobile = telMobile;
        this.fax = fax;
        this.nomsuser = nomsuser;
        this.tel = tel;
    }


}