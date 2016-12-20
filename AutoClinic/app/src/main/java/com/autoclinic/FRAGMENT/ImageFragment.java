package com.autoclinic.FRAGMENT;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.autoclinic.R;
import com.autoclinic.UTILS.Utiles;
import com.github.oliveiradev.image_zoom.lib.widget.ImageZoom;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.io.File;
import java.io.IOException;

/**
 * Created by SEYDOU BERTHE on 21/05/2016.
 */
public class ImageFragment  extends Fragment{

    private ImageZoom imgView;
    private Context context;
    private File imageFile;
    private RequestCreator creator;
    private boolean res = false;
    private String link;

    public void setUpLink(String url){
        link = url;
        res = true;
    }


    public void setCreator(RequestCreator c){
        creator = c;
        res = true;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.image_fragment_layout, container, false);
        //String path = getArguments().getString("pathi");
        imgView = (ImageZoom) layout.findViewById(R.id.imgId);
        //Log.e("PATH HHHHHHHH NAME", "N : "+imageFile.getAbsolutePath());
        //imgView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_block_black_48dp));
        if(!res) {
            imgView.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
        }
        else {
            //Log.e()
            Picasso.with(context).load(link).into(imgView);
        }

        return layout;
    }

    public ImageView getImageView(){
        return imgView;
    }

    public void setImageFile(File file){
        this.imageFile = file;
    }

    public void setImgView(Bitmap b) {
        this.imgView.setImageBitmap(b);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
