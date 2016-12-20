package com.autoclinic.ACTIVITIES;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.autoclinic.ADAPTER.AssuranceRecyclerAdapter;
import com.autoclinic.FRAGMENT.AssuranceFragment;
import com.autoclinic.FRAGMENT.ClientFragment;
import com.autoclinic.FRAGMENT.CustomDialogClass;
import com.autoclinic.FRAGMENT.DisplayFragment;
import com.autoclinic.FRAGMENT.MainFragment;
import com.autoclinic.FRAGMENT.VehiculeFragment;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Assurance1;
import com.autoclinic.MODEL.AssuranceSvcApi;
import com.autoclinic.MODEL.Bridge;
import com.autoclinic.MODEL.Client;
import com.autoclinic.MODEL.Client1;
import com.autoclinic.MODEL.ComFragMain;
import com.autoclinic.MODEL.Communicator;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.Param;
import com.autoclinic.R;
import com.autoclinic.UTILS.Entry;
import com.autoclinic.UTILS.Utiles;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Communicator, ComFragMain, Bridge{

    private FloatingActionButton fab;
    private FragmentManager fragmentManager;
    private RecyclerView assuranceRecycler;
    public Assurance current;
    public static MainActivity app;
    private boolean displayGrid = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app  = this;
        setContentView(R.layout.activity_main);

        //Init Compent Part
        fab = (FloatingActionButton) findViewById(R.id.fab);
        assuranceRecycler = (RecyclerView) findViewById(R.id.assurance);
        AssuranceRecyclerAdapter adapter = new AssuranceRecyclerAdapter(getApplicationContext(), new ArrayList<Assurance>());
        adapter.setUp(this);
        assuranceRecycler.setAdapter(adapter);
        assuranceRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        new getAssurance().execute();

        fragmentManager = getSupportFragmentManager();
        //addFragment(Entry.FICHE_FRAGMENT_TYPE);


        //Listener Definition Part
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Ajout de nouvelle fiche", Toast.LENGTH_SHORT).show();
                //replaceWithAddFragement();
                // ffab.setEnabled(false);
                setCleintFrag(null);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private List<Assurance1> getAssurances(){
        List<Assurance1> assurance1s = new ArrayList<Assurance1>();
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.liste_assurances));
        for(int i = 0; i<names.size(); i++){
            Assurance1 tmp = new Assurance1();
            tmp.setId(i);
            tmp.setNom(names.get(i));
            assurance1s.add(tmp);
        }
        return assurance1s;
    }

    /**
     * Method retournant la liste des assurances
     * @return
     */
    private List<Assurance> getListAssurance(){
       AssuranceSvcApi svc =  Utiles.createAssuranceSvc();
        return svc.getAllAssurance();
    }

    public void addFragment(String type){
        switch (type){
            case Entry.FICHE_FRAGMENT_TYPE :
                MainFragment ficheFrag = new MainFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainLayout, ficheFrag, Entry.FICHE_FRAGMENT_TYPE);
                transaction.commit();
                break;
            case Entry.FORM_FRAGMENT_TYPE :
                AssuranceFragment assuFrag = new AssuranceFragment();
                FragmentTransaction trans = fragmentManager.beginTransaction();
                trans.replace(R.id.mainLayout, assuFrag, Entry.FICHE_FRAGMENT_TYPE);
                trans.commit();
                break;
            default:
                break;
        }
    }

    public void replaceWithAddFragement(){
        VehiculeFragment vehicule = new VehiculeFragment();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.mainLayout, vehicule, Entry.ADD_FRAG_FICHE);
        trans.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.en_cour :
                Toast.makeText(getBaseContext(), "En cours ! ", Toast.LENGTH_SHORT).show();
                displayFiches(current, 1);
                break;

            case R.id.inco :
                Toast.makeText(getBaseContext(), "Incomplete ! ", Toast.LENGTH_SHORT).show();
                displayFiches(current, 0);
                break;

            case R.id.arch :
                Toast.makeText(getBaseContext(), "Archiver ! ", Toast.LENGTH_SHORT).show();
                displayFiches(current, 2);
                break;
            case R.id.display:
                if(displayGrid) {
                    displayFichesV2(current, -1, Entry.TYPE_LIST);
                    displayGrid = false;
                }else{
                    displayFichesV2(current, -1, Entry.TYPE_GRID);
                    displayGrid = true;
                }
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void setListFiche(){

    }



    @Override
    public void assuranceItemClick(Assurance assurance1) {
        current = assurance1;
        //Toast.makeText(getApplicationContext(), "Assurance1 "+ assurance1.getName()+" a ete clique", Toast.LENGTH_SHORT).show();
        /*if(fab.isEnabled()){
            fab.setEnabled(true);
        }*/
        displayFiches(assurance1, -1);
    }

    public void displayFiches(Assurance  a, int etat){
        MainFragment ficheFrag = new MainFragment();
        Param p = new Param(); p.nomAssu = a.getName(); p.etat = etat;
        ficheFrag.setUpData(p, Entry.TYPE_GRID);
        ficheFrag.setUp(this);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainLayout, ficheFrag, Entry.FICHE_FRAGMENT_TYPE);
        transaction.commit();
    }

    public void displayFichesV2(Assurance  a, int etat, String type){
        MainFragment ficheFrag = new MainFragment();
        Param p = new Param(); p.nomAssu = a.getName(); p.etat = etat;
        ficheFrag.setUpData(p, type);
        ficheFrag.setUp(this);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainLayout, ficheFrag, Entry.FICHE_FRAGMENT_TYPE);
        transaction.commit();
    }


    @Override
    public void skip(Client1 c) {
        VehiculeFragment vehicule = new VehiculeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("client", c);
        vehicule.setArguments(bundle);
        vehicule.setUp(this);
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.mainLayout, vehicule, Entry.ADD_FRAG_FICHE);
        trans.commit();
    }



    public void setCleintFrag(Client1 c) {
        ClientFragment cli = new ClientFragment();
        cli.setUp(this);
        Bundle bundle = new Bundle();
        bundle.putSerializable("client", c);
        cli.setArguments(bundle);
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.mainLayout, cli, "Client");
        trans.commit();
    }

    @Override
    public void setDisplayFrag(final Fiches fiches) {
        runOnUiThread(new Runnable() {
            public void run() {
                DisplayFragment ficheFrag = new DisplayFragment();
                ficheFrag.setUp(fiches, current);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainLayout, ficheFrag, Entry.FICHE_FRAGMENT_TYPE);
                transaction.commit();
            }
        });
    }

    public void showPieceDialog(){
        runOnUiThread(new Runnable() {
            public void run() {
                Log.e("SHOWING PIECE D", "PIECE DIALOGGGGg");
                CustomDialogClass c = new CustomDialogClass(MainActivity.this);
                c.show();
            }
        });
    }

    public void showEmployDialog(){
        runOnUiThread(new Runnable() {
            public void run() {
                Log.e("SHOWING PIECE D", "PIECE DIALOGGGGg");
                CustomDialogClass c = new CustomDialogClass(MainActivity.this);
                c.show();
            }
        });
    }



    @Override
    public void goToHome(String type) {
        addFragment(Entry.FICHE_FRAGMENT_TYPE);
    }

    class getAssurance extends AsyncTask<Void, Void, List<Assurance>> {

        @Override
        protected List<Assurance> doInBackground(Void... params) {

            Log.e("TAG Background working", "Background proccess");
            AssuranceSvcApi assuranceSvcApi = Utiles.createAssuranceSvc();
            return assuranceSvcApi.getAllAssurance();
        }

        @Override
        protected void onPostExecute(List<Assurance> assurances) {
            //super.onPostExecute(assurances);

            if(assurances != null) {
                //Log.e("TAGE UPDATE CALL Success ", "Update Call Success !");
                Toast.makeText(getBaseContext(), "Size Assurance "+assurances.size()+" Size fiches : "+assurances.get(0).getfiche(), Toast.LENGTH_SHORT).show();
                ((AssuranceRecyclerAdapter) assuranceRecycler.getAdapter()).updateAssurances((ArrayList<Assurance>) assurances);
                current = assurances.get(0);
            }else{
                Log.e("TAGE UPDATE CALL ERROR ", "Update Call Error !");
                Toast.makeText(getBaseContext(), "Update "+assurances.size(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
