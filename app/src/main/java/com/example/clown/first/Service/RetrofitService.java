package com.example.clown.first.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cLown on 3/7/2018.
 */

public class RetrofitService {

    public Retrofit getService(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://jasamedika.000webhostapp.com/server/public/service/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());;

        return builder.build();
    }
}
