package com.kangadit.infocovid19.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.kangadit.infocovid19.network.CoronaDataService;
import com.kangadit.infocovid19.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndonesiaRepository {

    private  String TAG = "IndonesiaRepository";
    private MutableLiveData<List<IndonesiaResponse>> mutableLiveDataInd = new MutableLiveData<>();

    public IndonesiaRepository(){

    }

    public MutableLiveData<List<IndonesiaResponse>> getMutableLiveData(){
        final CoronaDataService coronaDataService = RetrofitClient.getService();
        Call<List<IndonesiaResponse>> call = coronaDataService.getIndonesia();
        call.enqueue(new Callback<List<IndonesiaResponse>>() {
            @Override
            public void onResponse(Call<List<IndonesiaResponse>> call, Response<List<IndonesiaResponse>> response) {
                if (response.isSuccessful()){
                    mutableLiveDataInd.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<IndonesiaResponse>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getCause());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });

        return mutableLiveDataInd;
    }

}
