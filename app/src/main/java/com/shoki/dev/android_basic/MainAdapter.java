package com.shoki.dev.android_basic;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shoki.dev.basic.base.adapter.BaseHeaderRecyclerAdapter;
import com.shoki.dev.basic.base.adapter.BaseRecyclerAdapter;
import com.shoki.dev.basic.base.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by shoki on 2017. 3. 22..
 */

public class MainAdapter extends BaseHeaderRecyclerAdapter<String, HeaderView> {

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        return new MainHeaderHolder(getHeaderItem());
    }



    public class MainViewHolder extends BaseViewHolder<String> {

        @BindView(R.id.item_main_txtv)
        TextView txtv;

        protected MainViewHolder(ViewGroup parent) {
            super(R.layout.item_main, parent);
        }

        @Override
        public void onBindViewHolder(String item, int position) {
            txtv.setText(item + "////" + String.valueOf(position));
        }
    }

    public class MainHeaderHolder extends BaseViewHolder<HeaderView> {

        @BindView(R.id.item_main_bg)
        View bg;

        public MainHeaderHolder(View view) {
            super(view);
        }


        @Override
        public void onBindViewHolder(HeaderView item, int position) {
            item.change();
        }
    }
}
