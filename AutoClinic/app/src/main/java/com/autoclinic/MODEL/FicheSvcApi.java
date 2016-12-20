package com.autoclinic.MODEL;

import com.autoclinic.UTILS.Entry;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;

/**
 * Created by SEYDOU BERTHE on 20/06/2016.
 */
public interface FicheSvcApi {

    @GET(Entry.LISTE_FICHE)
    public List<Fiches> getAllFicheByState(@Path("assurancename")String assuName, @Path("etat") int state);

    @POST(Entry.ADD_FICHE)
    public void addFiche(@Path("assurance") String ass, @Path("fiche") String fiche, @Body Fiches f);

    @Multipart
    @POST("/fiche/uploadImg")
    public boolean upload(
                          @Part("name") String name,
                          @Part("file")TypedFile file
    );


    @GET(Entry.ADD_FICHE_V3)
    public String addFicheV3(@Path("Assurancename") String Assurancename,
                             @Path("fichename") String fichename,@Path("immatriculation")String immatriculation,@Path("marque")String marque,@Path("Modele")String Modéle,@Path("NumChassais")String NumChassais,@Path("kilometrage")String kilométrage,@Path("nivcarburant")String nivcarburant,
                             @Path("Receptionle")String Receptionle,@Path("noms")String noms,@Path("Adresse")String Adresse,@Path("telbureau")String telBureau,@Path("telMobile")String telMobile,@Path("fax")String fax,@Path("nomuser")String nomuser,@Path("tel")String tel);

    @GET("/fiche/save")
    public boolean addFicheV4(@Query("Assurancename") String Assurancename,
                             @Query("fichename") String fichename,
                             @Query("immatriculation")String immatriculation,
                             @Query("marque")String marque,
                             @Query("Modele")String Modéle,
                             @Query("NumChassais")String NumChassais,
                             @Query("kilometrage")String kilometrage,
                             @Query("nivcarburant")String nivcarburant,
                             @Query("Receptionle")String Receptionle,
                             @Query("noms")String noms,
                             @Query("Adresse")String Adresse,
                             @Query("telbureau")String telBureau,
                             @Query("telMobile")String telMobile,
                             @Query("fax")String fax,
                             @Query("nomuser")String nomuser,
                             @Query("tel")String tel,
                             @Query("etat") int etat
        );

    @GET("/fiche/delete/{assurancename}/{fichename}")
    public boolean deleteFiche(@Path("assurancename")String assName, @Path("fichename")String  fichName);

    @GET("/fiche/deleteV2")
    public boolean deleteFicheV2(@Query("assurancename") String assName, @Query("fichename")String  fichName);


    @GET("/employer/list/{function}")
    public List<Employer> getAllEmployer(@Path("function") String function);

    @GET("/employer/affect/{fichename}/{employername}")
    public String addEmployer(@Path("fichename") String fiche, @Path("employername") String employ);

    @GET("/employer/affectV2")
    public String addEmployerV2(@Query("fichename") String fiche, @Query("employername") String employ);

    @GET("/employer/affectV3")
    public String addEmployerV3(@Query("ficheid") int fiche, @Query("employerid") int employ);

    @GET("/fiche/archiver")
    public int archiveFiche(@Query("fichename") String ficheName);

    @GET("/piece/savepiece/{fichename}/{piecename}/{categoriename}")
    public String addPiece(@Path("fichename")String ficheN, @Path("piecename")String pieceName, @Path("categoriename")String pieceCat);


    @GET("/piece/savepieceV2")
    public String addPieceV2(@Query("fichename") String ficheN, @Query("piecename")String pieceName, @Query("categoriename")String pieceCat);


    //@GET(Entry.ADD_FICHE_V2)
    @GET("/fiche/addV2")
    public boolean addFicheV2(@Query("assurance") String assurance,
                              @Query("fiche") String fiche,
                              @Query("nom") String nom,
                              @Query("address") String address,
                              @Query("email") String email,
                              @Query("mobile") int mobile,
                              @Query("tel") int tel,
                              @Query("fax") int fax,
                              @Query("marque")String marque ,
                              @Query("modele")String modele,
                              @Query("immatriculation")String immatriculation,
                              @Query("NumChassais")int NumChassais,
                              @Query("kilometrage")String kilométrage,
                              @Query("nivcarburant")String nivcarburant);

}
