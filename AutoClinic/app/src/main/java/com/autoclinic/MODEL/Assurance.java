package com.autoclinic.MODEL;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */


import java.io.Serializable;
import java.util.List;

public class Assurance implements Serializable{

    private String name;
    private List<fiche> fiche;


    public List<fiche> getfiche() {
        return fiche;
    }

    public void setFiches(List<fiche> fiches) {
        this.fiche = fiches;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Assurance(){
    }
}
