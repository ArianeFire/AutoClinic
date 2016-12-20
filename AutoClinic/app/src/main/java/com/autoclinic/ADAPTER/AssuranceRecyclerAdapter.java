package com.autoclinic.ADAPTER;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.autoclinic.MODEL.Assurance;
import com.autoclinic.MODEL.Communicator;
import com.autoclinic.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SEYDOU BERTHE on 03/05/2016.
 */
public class AssuranceRecyclerAdapter extends RecyclerView.Adapter<AssuranceRecyclerAdapter.AssuranceViewHolder> {

    private int current ;
    private boolean first = true;
    private Context context;
    private LayoutInflater inflater;
    private List<Assurance> assurance1s = Collections.EMPTY_LIST;
    private Communicator communicator;

    public AssuranceRecyclerAdapter(Context context, ArrayList<Assurance> assurance1s){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.assurance1s = assurance1s;
    }

    public void updateAssurances(ArrayList<Assurance> newA){
        assurance1s = newA;
        notifyDataSetChanged();
    }

    public void setUp(Activity activity){
        communicator = (Communicator)activity;
    }

    @Override
    public AssuranceRecyclerAdapter.AssuranceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.assurance_recycler_layout, parent, false);
        AssuranceViewHolder holder = new AssuranceViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(AssuranceRecyclerAdapter.AssuranceViewHolder holder, int position) {

        Assurance assurance1 = assurance1s.get(position);
        holder.assuranceName.setText(assurance1.getName());

    }

    @Override
    public int getItemCount() {
        return assurance1s.size();
    }

    private View last;

    class AssuranceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView assuranceName;

        public AssuranceViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            assuranceName = (TextView) itemView.findViewById(R.id.assuranceName);
        }

        @Override
        public void onClick(View v) {
            communicator.assuranceItemClick(assurance1s.get(getPosition()));
            if(!first){
                last.setBackgroundColor(context.getResources().getColor(R.color.bl));
                v.setBackgroundColor(context.getResources().getColor(R.color.b));
            }else{
                //last.setBackgroundColor(context.getResources().getColor(R.color.w));
                v.setBackgroundColor(context.getResources().getColor(R.color.b));
                first = false;
            }
            last = v;
        }
    }

}
