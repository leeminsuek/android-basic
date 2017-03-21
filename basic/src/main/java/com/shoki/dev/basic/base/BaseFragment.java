package com.shoki.dev.basic.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shoki.dev.basic.network.NetworkManager;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by shoki on 2017. 2. 1..
 */

public abstract class BaseFragment extends Fragment {

    public BaseFragment() {

    }

    @LayoutRes
    protected abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(view != null) {
            ButterKnife.bind(this, view);
        }
    }

    public <T>void request(Call<T> call, Callback<T> callback) {
        NetworkManager.request(getActivity(), call, callback);
    }
}
