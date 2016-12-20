package com.autoclinic.MODEL;

/**
 * Created by SEYDOU BERTHE on 28/05/2016.
 */
public class Vehicule1 {

    private String marque;
    private String modele;
    private String immat;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public String getChasset() {
        return chasset;
    }

    public void setChasset(String chasset) {
        this.chasset = chasset;
    }

    public String getKilo() {
        return kilo;
    }

    public void setKilo(String kilo) {
        this.kilo = kilo;
    }

    public String getNiveauC() {
        return niveauC;
    }

    public void setNiveauC(String niveauC) {
        this.niveauC = niveauC;
    }

    private String chasset;
    private String kilo;
    private String niveauC;
}
