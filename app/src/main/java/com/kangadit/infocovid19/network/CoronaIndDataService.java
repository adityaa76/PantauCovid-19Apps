package com.kangadit.infocovid19.network;

import com.kangadit.infocovid19.model.ProvinsiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaIndDataService {
    @GET("indonesia")
    Call<List<ProvinsiResponse>> getCorona();
}
