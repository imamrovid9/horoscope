package com.tugas.ramalanzodiac.api;

import com.tugas.ramalanzodiac.MainModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("aries/today")
    Call<MainModel> getAries();
    @GET("taurus/today")
    Call<MainModel> getTaurus();
    @GET("gemini/today")
    Call<MainModel> getGemini();
    @GET("cancer/today")
    Call<MainModel> getCancer();
    @GET("leo/today")
    Call<MainModel> getLeo();
    @GET("virgo/today")
    Call<MainModel> getVirgo();
    @GET("libra/today")
    Call<MainModel> getLibra();
    @GET("scorpio/today")
    Call<MainModel> getScorpio();
    @GET("sagittarius/today")
    Call<MainModel> getSagitarius();
    @GET("capricorn/today")
    Call<MainModel> getCapricorn();
    @GET("aquarius/today")
    Call<MainModel> getAquarius();
    @GET("pisces/today")
    Call<MainModel> getPisces();
}
