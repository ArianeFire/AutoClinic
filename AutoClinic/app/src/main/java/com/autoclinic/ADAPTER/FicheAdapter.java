package com.autoclinic.ADAPTER;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.autoclinic.ACTIVITIES.MainActivity;
import com.autoclinic.FRAGMENT.EmployDialog;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Assurance1;
import com.autoclinic.MODEL.FicheSvcApi;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.Param;
import com.autoclinic.MODEL.fiche;
import com.autoclinic.R;
import com.autoclinic.UTILS.Utiles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 04/05/2016.
 */
public class FicheAdapter extends BaseAdapter {

    private List<Fiches> fiches;
    private Context context;
    private Param param;
    private int current;
    private Activity activity;


    public void setUp(Activity a){
        activity = a;
    }

    public FicheAdapter(Context context, ArrayList<Fiches> assurance1s, Param p){
        this.context = context;
        this.fiches = assurance1s;
        param = p;
    }

    public void updateFiche(List<Fiches> fiches){
        this.fiches = fiches;
        notifyDataSetChanged();
    }

    public boolean deleteFicheByName(String name){

        boolean tmp = false;
        for(int i =0; i<fiches.size(); i++){
            if(fiches.get(i).getName().equals(name)){
                fiches.remove(i);
                tmp = true;
                break;
            }
        }

        return tmp;
    }


    @Override
    public int getCount() {
        return fiches.size();
    }

    @Override
    public Object getItem(int position) {
        return fiches.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fiche_list_layout, parent, false);
        }

        final TextView ficheName = (TextView) convertView.findViewById(R.id.ficheName);
        ficheName.setText("Fich. M  "+fiches.get(position).getVehicule().getMarque()+" Mat "+fiches.get(position).getVehicule().getImmatriculation());

        //Click sur le boutton Archiver
        ((ImageButton)convertView.findViewById(R.id.archiverr)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ArchiverFiche().execute(fiches.get(position).getName());
            }
        });

        //Click sur QQQQ le boutto ouvrir
        ((ImageButton)convertView.findViewById(R.id.open)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.app.setDisplayFrag(fiches.get(position));
            }
        });

        //Click sur le boutton supprimer
        ((ImageButton)convertView.findViewById(R.id.delete)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DeleteParamHolder holder = new DeleteParamHolder();
                holder.ass = param.nomAssu;
                holder.fiche = fiches.get(position).getName();

                new DeleteFicheAsync().execute(holder);
            }
        });

        //Click sur le boutton ajout employer
        ((ImageButton)convertView.findViewById(R.id.employ)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmployDialog dialog = new EmployDialog(activity, param, fiches.get(position).getId());
                dialog.show();
            }
        });

        return convertView;
    }

    class ListHolder {
        private TextView ficheName;

        public ListHolder(View v){
            ficheName = (TextView) v.findViewById(R.id.ficheName);
        }
    }

    class DeleteParamHolder {
        public String ass;
        public String fiche;
    }

   class DeleteFicheAsync extends AsyncTask<DeleteParamHolder, Void, Boolean>{

       @Override
       protected Boolean doInBackground(DeleteParamHolder... params) {
           FicheSvcApi api = Utiles.createFicheSvc();
           deleteFicheByName(params[0].fiche);
           return api.deleteFicheV2(params[0].ass, params[0].fiche);
       }

       @Override
       protected void onPostExecute(Boolean aBoolean) {
           super.onPostExecute(aBoolean);
           notifyDataSetChanged();
           //notifyAll();
       }
   }

    class ArchiverFiche extends AsyncTask<String, Void, Integer>{

        @Override
        protected Integer doInBackground(String... params) {
            FicheSvcApi api = Utiles.createFicheSvc();
            deleteFicheByName(params[0]);
            return api.archiveFiche(params[0]);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            notifyDataSetChanged();
            Toast.makeText(context, "Fiche Archiver !", Toast.LENGTH_SHORT).show();
        }
    }
}
