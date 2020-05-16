package com.kangadit.infocovid19.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kangadit.infocovid19.R;
import com.kangadit.infocovid19.databinding.CoronaListItemBinding;
import com.kangadit.infocovid19.model.ProvinsiResponse;

import java.util.ArrayList;
import java.util.List;

public class ProvinsiDataAdapter extends RecyclerView.Adapter<ProvinsiDataAdapter.CoronaViewHolder> {

    private ArrayList<ProvinsiResponse> corona;

    public ProvinsiDataAdapter(List<ProvinsiResponse> coronaList){

    }

    @NonNull
    @Override
    public CoronaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CoronaListItemBinding coronaListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.corona_list_item,viewGroup, false);
        return new CoronaViewHolder(coronaListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoronaViewHolder coronaViewHolder, int i) {
        ProvinsiResponse c = corona.get(i);
        coronaViewHolder.coronaListItemBinding.setCorona(c);
    }

    @Override
    public int getItemCount() {
        if (corona != null){
            return corona.size();
        } else {
            return 0;
        }
    }

    public void setCoronaList(ArrayList<ProvinsiResponse> corona){
        this.corona = corona;
        notifyDataSetChanged();
    }

    static class CoronaViewHolder extends RecyclerView.ViewHolder {
        private CoronaListItemBinding coronaListItemBinding;

        CoronaViewHolder(@NonNull CoronaListItemBinding coronaListItemBinding){
            super(coronaListItemBinding.getRoot());
            this.coronaListItemBinding = coronaListItemBinding;
        }
    }
}
