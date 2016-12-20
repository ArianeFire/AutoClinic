package com.autoclinic.ACTIVITIES;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.autoclinic.R;


public class Main2Activity extends Activity {

    private static final String PREF_FILE_NAME = "prf_nam" ;
    private static final String PREF_USER_NAME = "prf_user_n" ;
    private static final String PREF_USER_PASS = "prf_pass_n" ;

    private EditText user;
    private EditText mdp;
    private ImageButton validate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        user = (EditText) findViewById(R.id.user);
        mdp = (EditText) findViewById(R.id.mdp);
        validate = (ImageButton) findViewById(R.id.validate);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user.getText().toString().equals("") && !mdp.getText().toString().equals("")){
                    if(user.getText().toString().equals(getResources().getString(R.string.user_name)) && mdp.getText().toString().equals(getResources().getString(R.string.mdp))){
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        saveToSharedPreference(getApplicationContext(), PREF_USER_NAME, getResources().getString(R.string.user_name));
                        saveToSharedPreference(getApplicationContext(), PREF_USER_PASS, getResources().getString(R.string.mdp));
                        startActivity(intent);
                        //finish();
                    }else{
                        user.setText("");
                        mdp.setText("");
                        Toast.makeText(Main2Activity.this, "Les informations saisies sont incorrectes", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    user.setText("");
                    mdp.setText("");
                    Toast.makeText(Main2Activity.this, "Verfier les champs saisies", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(readFromSharedPreference(getApplicationContext(), PREF_USER_NAME, "seydouTwo").equals("seydouOne") &&
                readFromSharedPreference(getApplicationContext(), PREF_USER_PASS, "and").equals("android")){
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    public static void saveToSharedPreference(Context t, String prefName, String prefValue){

        //Open SharedPreferences In Private Mode => Our App is the Only On which can Access It
        SharedPreferences shared = t.getSharedPreferences(PREF_FILE_NAME, t.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(prefName, prefValue);
        editor.apply();
    }

    public static  String readFromSharedPreference(Context context, String prefName, String defValue){
        SharedPreferences shared = context.getSharedPreferences(PREF_FILE_NAME, context.MODE_PRIVATE);
        return shared.getString(prefName, defValue);
    }

}
