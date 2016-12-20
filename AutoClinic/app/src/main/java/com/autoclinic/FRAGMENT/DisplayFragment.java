package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Client1;
import com.autoclinic.MODEL.Employer;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.Piece;
import com.autoclinic.MODEL.Vehicule;
import com.autoclinic.R;
import com.autoclinic.UTILS.Entry;
import com.autoclinic.UTILS.Utiles;
import com.squareup.picasso.Picasso;

import org.slf4j.helpers.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 24/06/2016.
 */
public class DisplayFragment extends Fragment {

    private Fiches fiches;
    private Assurance ass;
    private Context context;
    private LinearLayout group;
    private ListView liste;

    public void setUp(Fiches fiches, Assurance a){
        this.fiches = fiches;
        ass = a;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.display_fiche_layout_v2, container, false);

        ((ImageView)layout.findViewById(R.id.marqueImg)).setImageBitmap(BitmapFactory.decodeResource(getResources(), Entry.getMarqueImgResByName(context, fiches.getVehicule().getMarque())));
        ((ImageView)layout.findViewById(R.id.modeleImg)).setImageBitmap(BitmapFactory.decodeResource(getResources(), Entry.getModeleImgResByName(context, fiches.getVehicule().getMarque(), fiches.getVehicule().getModele())));
        ((TextView)layout.findViewById(R.id.modeleName)).setText(fiches.getVehicule().getModele());
        ((TextView)layout.findViewById(R.id.immatriculation)).setText("Mat : "+fiches.getVehicule().getImmatriculation());
        ((TextView)layout.findViewById(R.id.numChasset)).setText("N°C : "+fiches.getVehicule().getNumChassais());
        ((TextView)layout.findViewById(R.id.kilo)).setText("Kil : "+fiches.getVehicule().getKilometrage());
        ((TextView)layout.findViewById(R.id.niveauCarburant)).setText("N.C : "+fiches.getVehicule().getNivcarburant());

        ((TextView)layout.findViewById(R.id.assurance)).setText(ass.getName());
        ((TextView)layout.findViewById(R.id.ficheName)).setText(fiches.getName());
        ((TextView)layout.findViewById(R.id.date)).setText(fiches.getClient().getReceptionle());


        ((TextView)layout.findViewById(R.id.client_name)).setText(fiches.getClient().getNoms());
        ((TextView)layout.findViewById(R.id.email)).setText(fiches.getClient().getNomsuser());
        ((TextView)layout.findViewById(R.id.address)).setText(fiches.getClient().getAdresse());
        ((TextView)layout.findViewById(R.id.tel)).setText(fiches.getClient().getTel());
        ((TextView)layout.findViewById(R.id.telm)).setText(fiches.getClient().getTelMobile());
        ((TextView)layout.findViewById(R.id.fax)).setText(fiches.getClient().getFax());



        liste = (ListView) layout.findViewById(R.id.employList);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.list_item, getEmployName(fiches.getEmployers()));

        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);

        group = (LinearLayout)layout.findViewById(R.id.groupLayout);

        String imat = fiches.getVehicule().getImmatriculation();

        Toast.makeText(context, "Piece Size : "+fiches.getPieces().size(), Toast.LENGTH_SHORT).show();


        for(int i = 0; i<fiches.getPieces().size(); i++){
            String fileName = imat+"_"+fiches.getPieces().get(i).getName();
            Log.e("PIECE NAME : ", fileName);
            ImageFragment frag = new ImageFragment();
            frag.setUpLink(Utiles.TEST_URL+"/fiche/upload?name="+fileName);

            FragmentTransaction trans = getChildFragmentManager().beginTransaction();
            trans.add(R.id.groupLayout, frag, fileName);
            trans.commit();
        }

        return layout;
    }

    class ParamImgDow {
        public List<Piece> pieces;
        public String imat;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context  = activity;
    }

    public void getImag(String fileName){

        String URL = Utiles.TEST_URL+"/fiche/upload?name="+fileName;
        /*Picasso.with(this.context)
                .load(URL).into(null);*/
    }

    public List<String> getEmployName(List<Employer> emps){

        Log.e("NUMBERS OF EMPLOYERS : ", "Employers Size : "+emps.size());
        ArrayList<String> name = new ArrayList<String>();
        if(emps != null) {
            for (int i = 0; i < emps.size(); i++) {
                Log.e("EMPLOYERS : "+i, "ADD TO LIST SUCCESSFULLY ! ==> "+emps.get(i).getNom() + " " + emps.get(i).getFonction());
                name.add(emps.get(i).getNom() + " " + emps.get(i).getFonction());
            }
        }

        return name;
    }
}
