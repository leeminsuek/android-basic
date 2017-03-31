package com.shoki.dev.android_basic;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shoki.dev.basic.base.adapter.BaseHeaderRecyclerAdapter;
import com.shoki.dev.basic.base.adapter.BaseViewHolder;

import butterknife.BindView;

/**
 * Created by shoki on 2017. 3. 22..
 */

public class MainAdapter extends BaseHeaderRecyclerAdapter<Shoki, HeaderView> {

    @Override
    protected RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        return new MainHeaderHolder(getHeaderItem());
    }

    public class MainViewHolder extends BaseViewHolder<Shoki> {

        @BindView(R.id.item_main_txtv)
        TextView txtv;

        protected MainViewHolder(ViewGroup parent) {
            super(R.layout.item_main, parent);
            itemView.setOnClickListener(v -> {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(null, getRealItemPosition(getAdapterPosition()));
                }
            });
        }

        @Override
        public void onBindViewHolder(Shoki item, int position) {
            txtv.setText(item.getId() + "////" + item.getName());
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
