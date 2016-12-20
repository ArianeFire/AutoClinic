package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;
import com.autoclinic.ACTIVITIES.MainActivity;
import com.autoclinic.ADAPTER.ImageSpinnerAdapter;
import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.AssuranceSvcApi;
import com.autoclinic.MODEL.Bridge;
import com.autoclinic.MODEL.Client;
import com.autoclinic.MODEL.Client1;
import com.autoclinic.MODEL.FicheSvcApi;
import com.autoclinic.MODEL.Fiches;
import com.autoclinic.MODEL.ModeleImage;
import com.autoclinic.MODEL.Param;
import com.autoclinic.MODEL.Piece;
import com.autoclinic.MODEL.Vehicule;
import com.autoclinic.R;
import com.autoclinic.UTILS.Entry;
import com.autoclinic.UTILS.Utiles;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.concurrent.ExecutionException;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;
import retrofit.mime.TypedFile;

/**
 * Created by SEYDOU BERTHE on 14/05/2016.
 */
public class VehiculeFragment extends Fragment {

    //Form control element
    private Spinner marque;
    private Spinner modele;
    private Spinner niveauCarb;
    private EditText immatricule;
    private EditText chassetNum;
    private EditText kilo;
    private Button terminer;
    private Button precedent;
    private Button suivant;
    private Button annuler;
    private ImageView photoTaker;

    private Client mClient;
    private String niveauC;
    private String nomMarque = "ALFA ROMEO";
    private String nomModele = "NOT SPECIFIED";
    Calendar c = Calendar.getInstance();
    private String mDaate = c.get(Calendar.DATE) + " "+c.get(Calendar.MONTH) + " "+ c.get(Calendar.YEAR) + " "+c.get(Calendar.HOUR_OF_DAY) + "h"+c.get(Calendar.MINUTE);
    private String mAssurance;

    //Frag Element
    private Context context;
    private ArrayList<File> listeImage = new ArrayList<File>();
    private Spinner liste;
    private Bridge brigde;
    private CustomDialogClass dialogClass;
    private Activity activity;
    public static VehiculeFragment app;
    private boolean isComplete = true;

    public void setUp(Activity a){
        brigde = (Bridge)a;
        activity = a;
    }


    SublimePickerFragment.Callback mFragmentCallback = new SublimePickerFragment.Callback() {
        @Override
        public void onCancelled() {

        }

        @Override
        public void onDateTimeRecurrenceSet(SelectedDate selectedDate,
                                            int hourOfDay, int minute,
                                            SublimeRecurrencePicker.RecurrenceOption recurrenceOption,
                                            String recurrenceRule) {
            //date.setText("Date : "+selectedDate.toString()+" Heure : "+hourOfDay+"h"+minute+"min");

            mDaate = selectedDate+ " "+hourOfDay+"h"+minute+"min";
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        app = this;
        View layout = inflater.inflate(R.layout.vehicule_layout, container, false);


        //Assurance1 Guy
        liste = (Spinner) layout.findViewById(R.id.listAssurance);
        ArrayAdapter<CharSequence> adaptercc = new ArrayAdapter<CharSequence>(context, android.R.layout.simple_spinner_item, new ArrayList<CharSequence>());
        adaptercc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adaptercc);
        new getAssurance().execute();

        liste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mAssurance = (String)parent.getAdapter().getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Get Argument
        //mClient = (Client) getArguments().getSerializable("client") ;

        //Take Photo Button
        photoTaker = (ImageView) layout.findViewById(R.id.takePic);
        photoTaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogClass = new CustomDialogClass(activity);
                dialogClass.show();
            }
        });




        //Marque Spinner
        marque = (Spinner) layout.findViewById(R.id.marqueSpinner);
        ImageSpinnerAdapter adapter = new ImageSpinnerAdapter(context, R.layout.spinner_item_layout, getMarqueData());
        marque.setAdapter(adapter);
        marque.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String marq = ((ImageSpinnerAdapter)marque.getAdapter()).getMarqueAt(position);
                ((ImageSpinnerAdapter)modele.getAdapter()).setData(Entry.getModelWithMarque(context, marq));
                nomMarque = ((ImageSpinnerAdapter)marque.getAdapter()).getMarqueAt(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Modele Spinner
        modele = (Spinner) layout.findViewById(R.id.modeleSpinner);
        ImageSpinnerAdapter adapter1 = new ImageSpinnerAdapter(context, R.layout.spinner_item_layout, Entry.getModelWithMarque(context, "Alfa"));
        modele.setAdapter(adapter1);

        modele.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nomModele = ((ImageSpinnerAdapter)modele.getAdapter()).getMarqueAt(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Niveau Spinner
        niveauCarb = (Spinner) layout.findViewById(R.id.niveau);

        ArrayAdapter<CharSequence> adapterc = ArrayAdapter.createFromResource(context,
                R.array.etat, android.R.layout.simple_spinner_item);
        adapterc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        niveauCarb.setAdapter(adapterc);
        niveauCarb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                niveauC = Entry.NIVEAU_CARB[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Immatriculation EditText
        immatricule = (EditText) layout.findViewById(R.id.immatriculation);

        //Chasset EditText
        chassetNum = (EditText) layout.findViewById(R.id.numChasset);

        //Kilometrage EditText
        kilo = (EditText) layout.findViewById(R.id.kilo);

        //Button En Bas
        layout.findViewById(R.id.terminer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mkilo = kilo.getText().toString();
                String mchassetNum = chassetNum.getText().toString();
                String mimmatriculation = immatricule.getText().toString();
                String mniveauC = niveauC+"";

                String toSave ="";

                Client1 cl = (Client1) getArguments().getSerializable("client");

                if(cl == null){
                    cl = new Client1();
                    cl.setNomsuser(Entry.PLACEHOLDER);
                    cl.setTelMobile(Entry.PLACEHOLDER);
                    cl.setTel(Entry.PLACEHOLDER);
                    cl.setNoms(Entry.PLACEHOLDER);
                    cl.setTelBureau(Entry.PLACEHOLDER);
                    cl.setFax(Entry.PLACEHOLDER);
                    cl.setAdresse(Entry.PLACEHOLDER);
                    cl.setReceptionle(mDaate);
                    isComplete = false;
                }

                //toSave = mDaate + Entry.SEPARATOR;
                Vehicule veh = new Vehicule(
                        nomMarque,
                        nomModele,
                        mimmatriculation,
                        mchassetNum,
                        mkilo,
                        mniveauC
                );

                cl.setReceptionle(mDaate);

                Fiches f = new Fiches();
                f.setClient(cl);
                f.setVehicule(veh);

                if(f.isValid())
                    new addFiche().execute(f);
                else
                    Toast.makeText(context, "Verifier les champs saisies !", Toast.LENGTH_SHORT).show();



                /*if(cl != null){
                    toSave += cl.getNom() + Entry.SEPARATOR +
                            cl.getEmail() + Entry.SEPARATOR +
                            cl.getAdresse() + Entry.SEPARATOR +
                            cl.getMobile() + Entry.SEPARATOR +
                            cl.getTel() + Entry.SEPARATOR +
                            cl.getFax() + Entry.SEPARATOR;
                }*/

                /*toSave += mAssurance + Entry.SEPARATOR +
                                nomMarque + Entry.SEPARATOR +
                                nomModele + Entry.SEPARATOR +
                                mimmatriculation + Entry.SEPARATOR +
                                mchassetNum + Entry.SEPARATOR +
                                mkilo + Entry.SEPARATOR +
                                mniveauC + "\n";

                if(Utiles.writeInFile(context, toSave)){
                    Toast.makeText(context, "Information inserted !", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(context, "Information not inserted !", Toast.LENGTH_SHORT).show();
                }*/


            }
        });

        layout.findViewById(R.id.prec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brigde.setCleintFrag(((Client1) getArguments().getSerializable("client")));
            }
        });

        /*layout.findViewById(R.id.suiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        layout.findViewById(R.id.annuler).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        layout.findViewById(R.id.launchPicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SublimePickerFragment pickerFrag = new SublimePickerFragment();
                pickerFrag.setCallback(mFragmentCallback);

                pickerFrag.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                pickerFrag.show(getFragmentManager(), "SUBLIME_PICKER");
            }
        });


        return layout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("ON RESULT HHHHHHHH", "Bro is been called !");
        /*if(resultCode == Activity.RESULT_OK) {
            if(requestCode == Picker.PICK_IMAGE_CAMERA) {
                imagePicker.submit(data);
                Log.e("ON RESULT HHHHHHHH", data.getData().toString());
            }
        }*/

        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {
                //Some error handling
            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                //Handle the image
                String p = Uri.fromFile(imageFile).toString();
                addImgFrag(p, imageFile);
                listeImage.add(imageFile);
                /*try {
                    Bitmap b = Utiles.decodeSampledBitmap(context, Uri.fromFile(imageFile));
                    Utiles.saveImageToExternal(context, "test", imageFile.getAbsolutePath()+"/Auto", b);
                    ParamImg pa = new ParamImg(); pa.name = "test"+listeImage.size(); pa.path = imageFile.getAbsolutePath()+"/Auto/test.png";
                    new uploadImg().execute(pa);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                Log.e("Image Location :  ", imageFile.getAbsolutePath());
                ParamImg pa = new ParamImg();

                if(!immatricule.getText().toString().equals("")){
                    pa.name = immatricule.getText().toString()+"_"+dialogClass.getSelectedPiece();
                    pa.path = imageFile.getAbsolutePath();
                    new uploadImg().execute(pa);
                }


                //MainActivity.app.showPieceDialog();

            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                //Cancel handling, you might wanna remove taken photo if it was canceled
                if (source == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(getActivity());
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }


    private void addImgFrag(String pat, File f){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        ImageFragment frag = new ImageFragment();
        frag.setImageFile(f);
        /*Bundle bundle = new Bundle();
        bundle.putString("pathi", pat);*/
        //frag.setArguments(bundle);
        trans.add(R.id.groupImageLayout, frag, pat);
        trans.commit();
    }

    public void takePick(){
        EasyImage.openCamera(VehiculeFragment.this, 222);
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




    private ArrayList<ModeleImage> getMarqueData(){

        ArrayList<ModeleImage> models = new ArrayList<ModeleImage>();

        int[] imageRes = new int[]{
                R.drawable.alfaromeo, R.drawable.audi, R.drawable.bmw,
                R.drawable.cadilac, R.drawable.chevrolet, R.drawable.chrysler,
                R.drawable.citroen, R.drawable.dacia, R.drawable.daewoo,
                R.drawable.daihatsu, R.drawable.dodge, R.drawable.ferrari,
                R.drawable.fiat, R.drawable.ford, R.drawable.honda,
                R.drawable.hyunda, R.drawable.isuzu, R.drawable.jaguar,
                R.drawable.jeep, R.drawable.kia, R.drawable.lamborghini,
                R.drawable.lancia, R.drawable.landrover, R.drawable.lexus,
                R.drawable.mazda, R.drawable.mercedesbenz, R.drawable.mgmarque,
                R.drawable.minimarque, R.drawable.mitsubishi, R.drawable.nissan,
                R.drawable.opel, R.drawable.peugeot, R.drawable.porsche,
                R.drawable.renault, R.drawable.rover, R.drawable.saab,
                R.drawable.seat, R.drawable.skoda, R.drawable.smart,
                R.drawable.ssangyong, R.drawable.subaru, R.drawable.suziki,
                R.drawable.toyota, R.drawable.volkswagen, R.drawable.volvo
        };

        List<String> marque = Arrays.asList(getResources().getStringArray(R.array.marques));

        for(int i = 0; i<imageRes.length; i++){
            ModeleImage mi = new ModeleImage();
            mi.setName(marque.get(i));
            mi.setResID(imageRes[i]);
            models.add(mi);
        }

        return models;
    }

    private ArrayList<ModeleImage> getModeleData(){

        ArrayList<ModeleImage> models = new ArrayList<ModeleImage>();

        int[] imageRes = new int[]{R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m9};

        List<String> marque = Arrays.asList(getResources().getStringArray(R.array.modeles));

        for(int i = 0; i<imageRes.length; i++){
            ModeleImage mi = new ModeleImage();
            mi.setName(marque.get(i));
            mi.setResID(imageRes[i]);
            models.add(mi);
        }

        return models;
    }

    class addFiche extends AsyncTask<Fiches, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Fiches... params) {

            Log.e("TAG Background working", "Background proccess");
            FicheSvcApi ficheSvcSvcApi = Utiles.createFicheSvc();

            String newD = mDaate;


            try {
                if(isComplete) {
                    return ficheSvcSvcApi.addFicheV4(mAssurance, "Rep. " + nomMarque + " du " + newD,
                            params[0].getVehicule().getImmatriculation(), params[0].getVehicule().getMarque(), params[0].getVehicule().getModele(),
                            params[0].getVehicule().getNumChassais(), params[0].getVehicule().getKilometrage(), params[0].getVehicule().getNivcarburant(),

                            newD,
                            params[0].getClient().getNoms(), params[0].getClient().getAdresse(), params[0].getClient().getTelBureau(),
                            params[0].getClient().getTelMobile(), params[0].getClient().getFax(),
                            params[0].getClient().getNomsuser(),
                            params[0].getClient().getTel(),
                            1
                    );
                }

                return ficheSvcSvcApi.addFicheV4(mAssurance, "Rep. " + nomMarque + " du " + newD,
                        params[0].getVehicule().getImmatriculation(), params[0].getVehicule().getMarque(), params[0].getVehicule().getModele(),
                        params[0].getVehicule().getNumChassais(), params[0].getVehicule().getKilometrage(), params[0].getVehicule().getNivcarburant(),

                        newD,

                        Entry.PLACEHOLDER, Entry.PLACEHOLDER, Entry.PLACEHOLDER,
                        Entry.PLACEHOLDER, Entry.PLACEHOLDER, Entry.PLACEHOLDER,
                        Entry.PLACEHOLDER,
                        0
                );

            }catch(Exception e){
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean res) {
            //super.onPostExecute(assurances);
            if(res) {
                Toast.makeText(context, "Insertion finish very well", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Insertion finish with !!.", Toast.LENGTH_SHORT).show();
            }

            if(dialogClass.getPiecesList() != null) {
                List<Piece> p = dialogClass.getPiecesList();
                if (p != null && p.size() > 0) {
                    for (int i = 0; i < p.size(); i++) {
                        try {
                            new AddPieces().execute(p.get(i));
                        } catch (Exception e) {
                            Log.e("Error during Piece Add:", "A ===> " + e.getMessage());
                        }
                    }
                }
            }

            brigde.goToHome(Entry.FICHE_FRAGMENT_TYPE);
        }
    }

    class getAssurance extends AsyncTask<Void, Void, List<Assurance>> {

        @Override
        protected List<Assurance> doInBackground(Void... params) {

            Log.e("TAG Background working", "Background proccess");
            AssuranceSvcApi assuranceSvcApi = Utiles.createAssuranceSvc();
            return assuranceSvcApi.getAllAssurance();
        }

        @Override
        protected void onPostExecute(List<Assurance> assurances) {
            //super.onPostExecute(assurances);
            List<CharSequence> list = new ArrayList<CharSequence>();
            for(int i = 0; i<assurances.size(); i++){
                list.add(assurances.get(i).getName());
            }
            if(assurances != null) {
                ArrayAdapter<CharSequence> f = new ArrayAdapter<CharSequence>(context, android.R.layout.simple_spinner_item,list);
                f.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                liste.setAdapter(f);
                if(assurances.size() > 0)
                    mAssurance = assurances.get(0).getName();
            }else{

            }
        }
    }

    class ParamImg {
        public String name;
        public String path;
    }

    class uploadImg extends AsyncTask<ParamImg, Void, Boolean>{

        @Override
        protected Boolean doInBackground(ParamImg... params) {
            FicheSvcApi uploadImgApi = Utiles.createFicheSvc();
            TypedFile file = new TypedFile("multipart/form-data", new File(params[0].path));
            return uploadImgApi.upload(params[0].name, file);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if(aBoolean){
                Toast.makeText(context, "Image Uploaded !", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Image Not Uploaded !", Toast.LENGTH_SHORT).show();
            }
        }
    }

    class AddPieces extends AsyncTask<Piece, Void, String>{

        @Override
        protected String doInBackground(Piece... params) {
            FicheSvcApi api = Utiles.createFicheSvc();
            String fn = "Rep. " + nomMarque + " du " + mDaate;
            try {
                return api.addPieceV2(fn, params[0].getName(), params[0].getCategorie());
            }catch (Exception c){
                return "no";
            }
        }

        @Override
        protected void onPostExecute(String s) {
           // super.onPostExecute(s);
            if(s!=null && s.equals("no")){
                Toast.makeText(context, "Insertion terminer avec succès !", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Piece ajouter", Toast.LENGTH_SHORT).show();

            }
        }
    }

}
