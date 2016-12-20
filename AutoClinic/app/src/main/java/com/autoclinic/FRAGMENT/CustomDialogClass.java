package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.autoclinic.MODEL.Communicator;
import com.autoclinic.MODEL.Piece;
import com.autoclinic.R;
import com.autoclinic.UTILS.Utiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomDialogClass extends Dialog implements
View.OnClickListener {

public Activity c;
public Dialog d;
private Context context;


private ImageButton valide;
	private ImageButton cancel;
	private Spinner cat;
	private Spinner pieces;
	private List<String> categories = Collections.EMPTY_LIST;
	private List<String> piece = Collections.EMPTY_LIST;
    private String selectedPiece;
    private String pieceCat;


public CustomDialogClass(Activity a) {
super(a);
// TODO Auto-generated constructor stub
this.c = a;
    context = a;
}

    private List<Piece> piecesList = new ArrayList<Piece>();

    public List<Piece>  getPiecesList(){
        return piecesList;
    }

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
	setContentView(R.layout.custom_dialog);

    cat = (Spinner) findViewById(R.id.categories);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.list_item, new ArrayList<String>());
    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    cat.setAdapter(adapter);

	pieces = (Spinner) findViewById(R.id.pieces);
    adapter = new ArrayAdapter<String>(context, R.layout.list_item, new ArrayList<String>());
    //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    pieces.setAdapter(adapter);

    new getCat().execute();

    //Changement de la piece
    pieces.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selectedPiece = piece.get(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

    //Changement de la categorie
    cat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //new getCat().execute();
            pieceCat = categories.get(position);
            new getPiece().execute(categories.get(position));

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });


	valide = (ImageButton) findViewById(R.id.validate);
    valide.setOnClickListener(this);
	cancel = (ImageButton) findViewById(R.id.cancel);
    cancel.setOnClickListener(this);
}

    public String getSelectedPiece(){
        return selectedPiece;
    }

@Override
public void onClick(View v) {

    switch (v.getId()){
        case R.id.validate :
            Piece tmp = new Piece(selectedPiece, pieceCat);
            piecesList.add(tmp);
            break;
        case R.id.cancel :
            selectedPiece = "cancel";
            break;
        default:
            break;
    }

	dismiss();
    VehiculeFragment.app.takePick();
}

    class getPiece extends AsyncTask<String, Void, List<String>>{

        @Override
        protected List<String> doInBackground(String... params) {
            try {
                return Utiles.Methodexml.getPiece(context, params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            piece = strings;
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.list_item, piece);
            //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            pieces.setAdapter(adapter);

            selectedPiece = piece.get(0);
        }
    }

    class getCat extends AsyncTask<Void, Void, List<String>>{

        @Override
        protected List<String> doInBackground(Void... params) {
            try {
                return Utiles.Methodexml.getCategorie(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<String> strings) {
            super.onPostExecute(strings);
            categories = strings;
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.list_item, categories);
            //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cat.setAdapter(adapter);

            new getPiece().execute(categories.get(0));
        }
    }
}