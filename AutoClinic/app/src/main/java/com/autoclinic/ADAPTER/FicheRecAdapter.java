package com.autoclinic.ADAPTER;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.autoclinic.ACTIVITIES.MainActivity;
import com.autoclinic.FRAGMENT.EmployDialog;
import com.autoclinic.MODEL.FicheSvcApi;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.Param;
import com.autoclinic.R;
import com.autoclinic.UTILS.Entry;
import com.autoclinic.UTILS.Utiles;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 29/06/2016.
 */
public class FicheRecAdapter extends RecyclerView.Adapter<FicheRecAdapter.FicheHolder> {

    private Context context;
    private List<Fiches> fiches = Collections.EMPTY_LIST;
    private Param param;
    private LayoutInflater inflater;
    private Activity activity;

    public void setUp(Activity a){
        activity = a;
    }

    public FicheRecAdapter(Context context, Param p){
        this.context = context;
        this.param = p;
        inflater = LayoutInflater.from(context);
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
    public FicheHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layout = inflater.inflate(R.layout.single_fiche_item, parent, false);
        FicheHolder holder = new FicheHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(FicheHolder holder, int position) {
        Fiches fiche = fiches.get(position);
        holder.title.setText(fiche.getName());
        holder.file.setImageBitmap(BitmapFactory.decodeResource(context.getResources(),Entry.getMarqueImgResByName(context, fiche.getVehicule().getMarque())));
    }

    @Override
    public int getItemCount() {
        return fiches.size();
    }

    class FicheHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView file;
        private ImageView view;
        private ImageView delete;
        private ImageView archiver;
        private ImageView employ;


        public FicheHolder(View item){
            super(item);
            title = (TextView) item.findViewById(R.id.title);
            file = (ImageView) item.findViewById(R.id.ficheImg);
            //view = (ImageButton) item.findViewById(R.id.open);
            delete = (ImageView) item.findViewById(R.id.delete);
            employ = (ImageView) item.findViewById(R.id.employ);
            archiver = (ImageView) item.findViewById(R.id.archiverr);


            archiver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new ArchiverFiche().execute(fiches.get(getPosition()).getName());
                }
            });

            file.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.app.setDisplayFrag(fiches.get(getPosition()));
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DeleteParamHolder holder = new DeleteParamHolder();
                    holder.ass = param.nomAssu;
                    holder.fiche = fiches.get(getPosition()).getName();

                    new DeleteFicheAsync().execute(holder);
                }
            });

            employ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EmployDialog dialog = new EmployDialog(activity, param, fiches.get(getPosition()).getId());
                    dialog.show();
                }
            });

        }

    }

    class DeleteParamHolder {
        public String ass;
        public String fiche;
    }

    class DeleteFicheAsync extends AsyncTask<DeleteParamHolder, Void, Boolean> {

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
