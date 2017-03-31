package com.shoki.dev.basic.network;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shoki on 2017. 3. 31..
 */

public class NetworkClient {

    private static Retrofit retrofit = null;
    public static Retrofit getClient(String baseUrl) {
        if(retrofit == null) {
            OkHttpClient client = new OkHttpClient();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.interceptors().add(loggingInterceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static void clear() {
        retrofit = null;
    }
}
