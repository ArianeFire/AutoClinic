package com.autoclinic.MODEL;

import com.autoclinic.UTILS.Entry;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */
public interface AssuranceSvcApi {

    @GET(Entry.LISTE_ASSURANCE)
    public List<Assurance> getAllAssurance();

    @GET(Entry.CREATE_ASSURANCE)
    public String createAssurance(@Query("nom") String name);
}
