package com.feizi.networkingusingretrofit2.networking;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Edalat on 2018/09/30.
 */

public class RetrofitClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if(retrofit == null){
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30,TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://www.mocky.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}
