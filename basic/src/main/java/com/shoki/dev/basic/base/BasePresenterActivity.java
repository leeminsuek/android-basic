package com.shoki.dev.basic.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by shoki on 2017. 2. 1..
 */

public abstract class BasePresenterActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {

    private Activity activity;
    protected P presenter;
    protected abstract P onCreatePresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = onCreatePresenter();
        if(presenter != null) {
            presenter.init();
            presenter.setView((V) this);//p->v
            presenter.setActivity(this);//ac
        }
    }

    public P getPresenter() {
        return presenter;
    }
}
