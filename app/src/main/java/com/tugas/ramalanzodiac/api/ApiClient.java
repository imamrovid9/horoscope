package com.tugas.ramalanzodiac.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://sandipbgt.com/theastrologer/api/horoscope/";

    private static Retrofit retrofit;
    public static Retrofit endpoint () {
        retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static ApiInterface getAries(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getTaurus(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getGemini(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getCancer(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getLeo(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getVirgo(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getLibra(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getScorpio(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getSagitarius(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getCapricorn(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getAquarius(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }

    public static ApiInterface getPisces(){
        ApiInterface ApiInterface = endpoint().create(ApiInterface.class);
        return ApiInterface;
    }
}



