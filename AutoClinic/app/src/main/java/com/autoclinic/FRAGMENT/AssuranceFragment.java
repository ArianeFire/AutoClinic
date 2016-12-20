package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.autoclinic.ADAPTER.AssuranceRecyclerAdapter;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Assurance1;
import com.autoclinic.MODEL.AssuranceSvcApi;
import com.autoclinic.R;
import com.autoclinic.UTILS.Utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 03/05/2016.
 */
public class AssuranceFragment extends Fragment {

    private RecyclerView assuranceRecycler;

    //Utils Variable
    private Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.assurance_fragment_layout, container, false);

        assuranceRecycler = (RecyclerView) layout.findViewById(R.id.assurance1);
        AssuranceRecyclerAdapter adapter = new AssuranceRecyclerAdapter(context, (ArrayList<Assurance>) getListAssurance());
        assuranceRecycler.setAdapter(adapter);
        assuranceRecycler.setLayoutManager(new LinearLayoutManager(context));

        return layout;
    }

    /**
     * Method retournant la liste des assurances
     * @return
     */
    private List<Assurance> getListAssurance(){
        AssuranceSvcApi svc =  Utiles.createAssuranceSvc();
        return svc.getAllAssurance();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity.getBaseContext();
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
}
