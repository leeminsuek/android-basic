package com.shoki.dev.basic.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shoki on 2017. 2. 1..
 */

public abstract class BasePresenterFragment<V extends BaseView, P extends BasePresenter<V>> extends BaseFragment {

    protected P presenter;
    protected abstract P onCreatePresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = onCreatePresenter();
        if(presenter != null) {
            presenter.init();
            presenter.setView((V) this);
            presenter.setActivity((AppCompatActivity) getActivity());
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public P getPresenter() {
        return presenter;
    }
}
