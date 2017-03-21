package com.shoki.dev.basic.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by shoki on 2017. 2. 1..
 */

public interface BasePresenter<V extends BaseView> {
    void setView(V view);
    void init();
    void setActivity(AppCompatActivity activity);
    AppCompatActivity getActivity();
}
