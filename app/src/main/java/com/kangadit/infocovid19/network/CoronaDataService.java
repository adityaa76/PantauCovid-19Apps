package com.kangadit.infocovid19.network;

import com.kangadit.infocovid19.model.IndonesiaResponse;
import com.kangadit.infocovid19.model.ProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaDataService {

    @GET("indonesia")
    Call<List<IndonesiaResponse>> getIndonesia();

    @GET("indonesia/provinsi")
    Call<List<ProvinsiResponse>> getProvinsi();

//    @GET("positif")
//    Call<GlobalDataResponse> getGlobalPositif();
//
//    @GET("sembuh")
//    Call<GlobalDataResponse> getGlobalSembuh();
//
//    @GET("meninggal")
//    Call<GlobalDataResponse> getGlobalMeninggal();
}
