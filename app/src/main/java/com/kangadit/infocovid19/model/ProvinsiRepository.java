package com.kangadit.infocovid19.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.kangadit.infocovid19.network.CoronaDataService;
import com.kangadit.infocovid19.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProvinsiRepository {
    private String TAG = "ProvinsiRepository";
    private MutableLiveData<List<ProvinsiResponse>> mutableLiveDataProv = new MutableLiveData<>();

    public ProvinsiRepository(){

    }

    public MutableLiveData<List<ProvinsiResponse>> getMutableLiveData(){
        final CoronaDataService coronaDataService = RetrofitClient.getService();
        Call<List<ProvinsiResponse>> call = coronaDataService.getProvinsi();
        call.enqueue(new Callback<List<ProvinsiResponse>>() {
            @Override
            public void onResponse(Call<List<ProvinsiResponse>> call, Response<List<ProvinsiResponse>> response) {
                if (response.isSuccessful()){
                    mutableLiveDataProv.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ProvinsiResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getCause());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return mutableLiveDataProv;
    }

}
