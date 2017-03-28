package com.shoki.dev.basic.base.mvp;

import android.support.v7.app.AppCompatActivity;

import com.shoki.dev.basic.network.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by shoki on 2017. 2. 1..
 */

public abstract class SuperPresenter<V extends BaseView> implements BasePresenter<V> {

    protected V view;
    private AppCompatActivity activity;

    public abstract void init();

    @Override
    public void setView(V view) {
        this.view = view;
    }

    @Override
    public AppCompatActivity getActivity() {
        return activity;
    }

    @Override
    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }

    public V getView() {
        return view;
    }

    public <T>void request(Call<T> call, Callback<T> callback) {
        NetworkManager.request(activity, call, callback);
    }
}
