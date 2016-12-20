package com.autoclinic.ACTIVITIES;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.autoclinic.R;

public class LoadActivity extends AppCompatActivity {

    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        img = (ImageView)findViewById(R.id.img);
        //new AsyncLoad().execute(8);
    }

    @Override
    protected void onStart() {
        Log.e("ONSTART", "........");
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ONRESUME", "...........");
        new AsyncLoad().execute(8);
    }

    class AsyncLoad extends AsyncTask<Integer, Void, Integer>{

        @Override
        protected Integer doInBackground(Integer... params) {
            return params[0];
        }

        @Override
        protected void onPostExecute(Integer load) {

            for(int i = 0; i<load.intValue(); i++){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            Intent intent = new Intent(LoadActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
