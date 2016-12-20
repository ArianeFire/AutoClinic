package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.autoclinic.MODEL.Client;
import com.autoclinic.MODEL.Client1;
import com.autoclinic.MODEL.ComFragMain;
import com.autoclinic.R;
import com.emmasuzuki.easyform.EasyTextInputLayout;

import java.util.regex.Pattern;

/**
 * Created by SEYDOU BERTHE on 25/05/2016.
 */
public class ClientFragment extends Fragment {

    private EditText nom;
    private EditText adresse;
    private EditText mobile;
    private EditText email;
    private EditText fax;
    private EditText tel;
    private Button ignore;
    private Button suiv;
    private Context context;

    private Client1 mClient;

    private Client1 commingClient;


    private ComFragMain com;

    public void setUp(Activity activity){
        com = (ComFragMain) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.client_layout, container, false);


        nom = (EditText) layout.findViewById(R.id.nom);
        adresse = (EditText) layout.findViewById(R.id.adresse);
        mobile = (EditText) layout.findViewById(R.id.telm);
        email = (EditText) layout.findViewById(R.id.email);
        fax = (EditText) layout.findViewById(R.id.fax);
        tel = (EditText) layout.findViewById(R.id.tel);


        //Ecouteur de changement de text
        nom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Pattern.matches("", s);
                if(s.toString().trim().equals(""))
                    nom.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    nom.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(nom.getText().equals("")){
                    nom.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                }
            }
        });

        adresse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(""))
                    adresse.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    adresse.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(""))
                    mobile.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    mobile.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(""))
                    email.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    email.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        fax.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(""))
                    fax.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    fax.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals(""))
                    tel.setBackgroundColor(context.getResources().getColor(R.color.fab_material_red_500));
                else
                    tel.setBackgroundColor(context.getResources().getColor(R.color.fab_material_green_500));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        commingClient = (Client1) getArguments().getSerializable("client");

        if(commingClient != null){
            nom.setText(commingClient.getNoms());
            adresse.setText(commingClient.getAdresse());
            mobile.setText(commingClient.getTelMobile());
            email.setText(commingClient.getNomsuser());
            fax.setText(commingClient.getFax());
            tel.setText(commingClient.getTel());

        }

        layout.findViewById(R.id.ignore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.skip(null);
            }
        });

        layout.findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nom.getText().toString();
                String adress = adresse.getText().toString();
                String mob = mobile.getText().toString();
                String emaill = email.getText().toString();
                String faxx = fax.getText().toString();
                String tell = tel.getText().toString();

                if(name.trim().equals("")){
                    nom.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    nom.setHint("Nom Obligatoire !");

                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                }else if(adress.trim().equals("")){
                    adresse.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    adresse.setHint("Adresse Obligatoire !");
                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                }else if(mob.trim().equals("")){
                    mobile.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    mobile.setHint("Mobile Obligatoire !");
                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                }else if(emaill.trim().equals("")) {
                    email.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    email.setHint("Email Obligatoire !");
                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                } else if(faxx.trim().equals("")){
                    fax.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    fax.setHint("Fax Obligatoire !");
                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                } else if(tell.trim().equals("")){
                    tel.setBackgroundColor(getResources().getColor(R.color.fab_material_red_500));
                    tel.setHint("Telephone Obligatoire !");
                    Toast.makeText(context, "Sinon Cliquer Ignorer !", Toast.LENGTH_SHORT).show();
                }else{
                    mClient = new Client1();
                    mClient.setNoms(name);  mClient.setAdresse(adress); mClient.setNomsuser(emaill);
                    mClient.setFax(faxx); mClient.setTelMobile(mob); mClient.setTelBureau(tell);
                    mClient.setTel(tell);
                    com.skip(mClient);
                }
            }
        });

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
}

