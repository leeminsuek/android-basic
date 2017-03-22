package com.shoki.dev.android_basic;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shoki.dev.basic.base.BaseRecyclerAdapter;
import com.shoki.dev.basic.base.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by shoki on 2017. 3. 22..
 */

public class MainAdapter extends BaseRecyclerAdapter<String, MainAdapter.MainViewHolder> {

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }

    public class MainViewHolder extends BaseViewHolder<String> {

        @BindView(R.id.item_main_txtv)
        TextView txtv;

        protected MainViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_main);
        }

        @Override
        protected void onClick(View view, String item) {

        }

        @Override
        protected void onBindView(String item, int position) {
            txtv.setText(item);
        }
    }
}
