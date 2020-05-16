package com.kangadit.infocovid19;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kangadit.infocovid19.model.IndonesiaRepository;
import com.kangadit.infocovid19.model.IndonesiaResponse;
import com.kangadit.infocovid19.model.ProvinsiRepository;
import com.kangadit.infocovid19.model.ProvinsiResponse;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ProvinsiRepository provinsiRepository;
    private IndonesiaRepository indonesiaRepository;

    public MainViewModel(@NonNull Application application){
        super(application);
        provinsiRepository = new ProvinsiRepository();
        indonesiaRepository = new IndonesiaRepository();
    }
    public LiveData<List<ProvinsiResponse>> getAllCorona(){
        return provinsiRepository.getMutableLiveData();
    }

    public LiveData<List<IndonesiaResponse>> getAllIndonesia(){
        return indonesiaRepository.getMutableLiveData();
    }

}
