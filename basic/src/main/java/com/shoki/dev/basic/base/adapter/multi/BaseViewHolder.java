package com.shoki.dev.basic.base.adapter.multi;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by shoki on 2017. 3. 21..
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, itemView);
    }

    public BaseViewHolder(@LayoutRes int layout, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(layout, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public abstract void onBindViewHolder(T item, int position, Section section);
}
