package com.shoki.dev.basic.network;

import android.app.Activity;

import retrofit2.Call;
import retrofit2.Callback;

public class NetworkManager {
    public static <T> void request(Activity activity, Call<T> call, Callback<T> callback) {
//        Command command = NetworkUtils.getAPI(activity);
        call.enqueue(callback);
    }
}