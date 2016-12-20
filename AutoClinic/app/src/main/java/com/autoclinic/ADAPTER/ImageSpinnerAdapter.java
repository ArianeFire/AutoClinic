package com.autoclinic.ADAPTER;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.autoclinic.MODEL.ModeleImage;
import com.autoclinic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 14/05/2016.
 */
public class ImageSpinnerAdapter extends ArrayAdapter {


    private Context context;
    private List<ModeleImage> data;
    private int i = 0;

    public ImageSpinnerAdapter(Context context, int resource, List<ModeleImage> objects) {
        super(context, resource, objects);
        this.context  = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();

    }

    public String getMarqueAt(int pos){
        return data.get(pos).getName();
    }

    public void setData(ArrayList<ModeleImage> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView  = LayoutInflater.from(context).inflate(R.layout.spinner_item_layout, parent, false);
        }

        ImageView v = (ImageView) convertView.findViewById(R.id.ressourceImage);
        v.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), data.get(position).getResID()));

        TextView name = (TextView) convertView.findViewById(R.id.enginName);
        name.setText(data.get(position).getName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView  = LayoutInflater.from(context).inflate(R.layout.spinner_item_layout, parent, false);
        }

        ImageView v = (ImageView) convertView.findViewById(R.id.ressourceImage);
        v.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), data.get(position).getResID()));
        TextView name = (TextView) convertView.findViewById(R.id.enginName);
        name.setText(data.get(position).getName());

        return convertView;
    }
}
