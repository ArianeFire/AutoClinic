package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.autoclinic.ADAPTER.AssuranceRecyclerAdapter;
import com.autoclinic.ADAPTER.FicheAdapter;
import com.autoclinic.ADAPTER.FicheRecAdapter;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Assurance1;
import com.autoclinic.MODEL.AssuranceSvcApi;
import com.autoclinic.MODEL.Fiche1;
import com.autoclinic.MODEL.FicheSvcApi;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.Param;
import com.autoclinic.MODEL.fiche;
import com.autoclinic.R;
import com.autoclinic.UTILS.Entry;
import com.autoclinic.UTILS.Utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 03/05/2016.
 */
public class MainFragment extends Fragment {


    private ListView listeFiches;
    private RecyclerView gridRec;
    private ImageButton ajoutEmployee;
    private ImageButton ouvrirFiche;
    private ImageButton supprimerFiche;
    private ImageButton archiverFiche;
    private Activity activity;
    private String typeDisplay = Entry.TYPE_GRID;

    public void setUp(Activity a){
        activity = a;
    }


    private Context context;
    private List<Fiches> fiches = Collections.EMPTY_LIST;

    Param param;

    public void setUpData(Param p, String type){

       new  getFiche().execute(p);
        param = p;
        typeDisplay = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View layout = null;

        if(typeDisplay.equals(Entry.TYPE_LIST)) {
            layout = inflater.inflate(R.layout.main_fragment_layout, container, false);
            listeFiches = (ListView) layout.findViewById(R.id.liste_fiches);
            FicheAdapter adapter = new FicheAdapter(context, new ArrayList<Fiches>(), param);
            adapter.setUp(activity);
            listeFiches.setAdapter(adapter);
        }else{
            layout = inflater.inflate(R.layout.main_fragment_layout_v2, container, false);
            gridRec = (RecyclerView) layout.findViewById(R.id.grid);

            FicheRecAdapter ficheRecAdapter = new FicheRecAdapter(context, param);
            ficheRecAdapter.setUp(activity);
            //gridRec.addItemDecoration(new MarginDecoration(context));
            gridRec.setHasFixedSize(true);
            gridRec.setLayoutManager(new GridLayoutManager(context, 4));

            gridRec.setAdapter(ficheRecAdapter);
        }


        return layout;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    /**
     * Method retournant la liste des assurances
     * @return
     */
    private List<Assurance> getListAssurances(){
        AssuranceSvcApi svc =  Utiles.createAssuranceSvc();
        return svc.getAllAssurance();
    }

    private List<Fiche1> getData(){
        ArrayList<Fiche1> fiches = new ArrayList<Fiche1>();
        List<String> fichesName = Arrays.asList(getResources().getStringArray(R.array.liste_fiches));

        for(int i = 0; i<fichesName.size(); i++){
            Fiche1 tmp = new Fiche1();
            tmp.setId(i);
            tmp.setName(fichesName.get(i));
            fiches.add(tmp);
        }
        return fiches;
    }

    private ArrayList<Assurance1> getListAssurance(){

        ArrayList<Assurance1> assurance1s = new ArrayList<Assurance1>();
        String data = Utiles.readFromFile(context);
        String[] assurance = data.split("[\n]");

        for(int i = 0; i<assurance.length; i++){
            String[] ass = assurance[i].split("[|]");
            Assurance1 tmp = new Assurance1();
            if(ass.length > 12){
                tmp.setDate(ass[0]);
                tmp.getmClient().setNom(ass[1]);
                tmp.getmClient().setEmail(ass[2]);
                tmp.getmClient().setAdresse(ass[3]);
                tmp.getmClient().setMobile(ass[4]);
                tmp.getmClient().setTel(ass[5]);
                tmp.getmClient().setFax(ass[6]);

                tmp.setNom(ass[7]);
                tmp.getVehicule1().setMarque(ass[8]);
                tmp.getVehicule1().setModele(ass[9]);
                tmp.getVehicule1().setImmat(ass[10]);
                tmp.getVehicule1().setChasset(ass[11]);
                tmp.getVehicule1().setKilo(ass[12]);
                tmp.getVehicule1().setNiveauC(ass[13]);
            }else{
                tmp.setDate(ass[0]);
                tmp.setNom(ass[1]);
                tmp.getVehicule1().setMarque(ass[2]);
                tmp.getVehicule1().setModele(ass[3]);
                tmp.getVehicule1().setImmat(ass[4]);
                tmp.getVehicule1().setChasset(ass[5]);
                tmp.getVehicule1().setKilo(ass[6]);
                tmp.getVehicule1().setNiveauC(ass[7]);
            }

            assurance1s.add(tmp);
        }

        return assurance1s;
    }

    class getFiche extends AsyncTask<Param, Void, List<Fiches>> {

        @Override
        protected List<Fiches> doInBackground(Param... params) {

            Log.e("TAG Background working", "Background proccess");
            FicheSvcApi ficheSvcSvcApi = Utiles.createFicheSvc();
            return ficheSvcSvcApi.getAllFicheByState(params[0].nomAssu, params[0].etat);
        }

        @Override
        protected void onPostExecute(List<Fiches> fiche) {
            //super.onPostExecute(assurances);
            if(fiche != null){
                fiches = fiche;
                if(typeDisplay.equals(Entry.TYPE_LIST))
                    ((FicheAdapter)listeFiches.getAdapter()).updateFiche(fiches);
                else
                    ((FicheRecAdapter)gridRec.getAdapter()).updateFiche(fiches);
            }
        }
    }



}
