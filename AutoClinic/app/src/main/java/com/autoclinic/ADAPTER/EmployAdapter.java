package com.autoclinic.ADAPTER;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.autoclinic.ACTIVITIES.MainActivity;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Assurance1;
import com.autoclinic.MODEL.Employer;
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
public class EmployAdapter extends BaseAdapter {

    private List<Employer> employers;
    private Context context;
    private Param param;
    private int current;
    private int ficheId;

    public EmployAdapter(Context context, ArrayList<Employer> employers, Param p, int ficheid){
        this.context = context;
        this.employers = employers;
        param = p;
        ficheId = ficheid;
    }

    public void updateEmploy(List<Employer> emp){
        this.employers = emp;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return employers.size();
    }

    @Override
    public Object getItem(int position) {
        return employers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.single_employ_item, parent, false);
        }

        ((TextView)convertView.findViewById(R.id.employName)).setText(employers.get(position).getNom() + "  " + employers.get(position).getFonction());

        final View finalConvertView = convertView;
        ((CheckBox)convertView.findViewById(R.id.check)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox) finalConvertView.findViewById(R.id.check)).isChecked()){
                    EmployParam p = new EmployParam();
                    p.ass = param.nomAssu;
                    p.emp = employers.get(position).getId();
                    p.fiche = ficheId;

                    new addEmploy().execute(p);
                }
            }
        });

        return convertView;
    }

    class addEmploy extends AsyncTask<EmployParam, Void, String>{

        @Override
        protected String doInBackground(EmployParam... params) {
            FicheSvcApi api = Utiles.createFicheSvc();
            try {
                return api.addEmployerV3(params[0].fiche, params[0].emp);
            }catch (Exception e){
                e.printStackTrace();
                return "Fiche Inserted";

            }
        }

        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        }
    }

    class EmployParam {
        public String ass;
        public int fiche;
        public int emp;
    }


}
