package com.autoclinic.FRAGMENT;

/**
 * Created by SEYDOU BERTHE on 25/06/2016.
 */

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.autoclinic.ADAPTER.EmployAdapter;
import com.autoclinic.MODEL.Employer;
import com.autoclinic.MODEL.FicheSvcApi;
import com.autoclinic.MODEL.Param;
import com.autoclinic.R;
import com.autoclinic.UTILS.Utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmployDialog extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    private Context context;
    private List<Employer> employers;
    private Param param;
    private int ficheId;


    public EmployDialog(Activity a, Param p, int ficheid) {
        super(a);
// TODO Auto-generated constructor stub
        this.c = a;
        context = a;

        //employers = emp;
        param = p;
        ficheId = ficheid;
    }

    private ListView employList;
    private Spinner fonction;
    private List<String> fonctionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.employ_layout);

        fonctionList = getFonctionData();

        fonction = (Spinner) findViewById(R.id.fonction);

        ArrayAdapter<String> adap = new ArrayAdapter<String>(context, R.layout.list_item, fonctionList);
        fonction.setAdapter(adap);

        fonction.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new GetEmployerByFunction().execute(fonctionList.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        employList = (ListView) findViewById(R.id.listEmploy);
        EmployAdapter adapter = new EmployAdapter(context, new ArrayList<Employer>(), param,ficheId);
        employList.setAdapter(adapter);
        //new getAllEmp().execute("all");

        new GetEmployerByFunction().execute(fonctionList.get(0));

    }

    public List<String> getFonctionData(){
        return Arrays.asList(context.getResources().getStringArray(R.array.fonction));
    }


    @Override
    public void onClick(View v) {
    }


    class getAllEmp extends AsyncTask<String, Void, List<Employer>>{

        @Override
        protected List<Employer> doInBackground(String... params) {

            FicheSvcApi api = Utiles.createFicheSvc();
            return api.getAllEmployer(params[0]);
        }

        @Override
        protected void onPostExecute(List<Employer> employers) {
            //super.onPostExecute(employers);

            if(employers != null)
                ((EmployAdapter)employList.getAdapter()).updateEmploy(employers);
            else
                Toast.makeText(context, "Employer not Fetch Successfully !", Toast.LENGTH_SHORT).show();

        }
    }

    class GetEmployerByFunction extends AsyncTask<String, Void, List<Employer>>{

        @Override
        protected List<Employer> doInBackground(String... params) {
            FicheSvcApi api = Utiles.createFicheSvc();
            return api.getAllEmployer(params[0]);
        }

        @Override
        protected void onPostExecute(List<Employer> employers) {

            if(employers != null){
                ((EmployAdapter)employList.getAdapter()).updateEmploy(employers);
            }
        }
    }

}
