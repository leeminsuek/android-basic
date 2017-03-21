package com.shoki.dev.basic.base;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by shoki on 2017. 3. 21..
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private T item;

    protected BaseViewHolder(ViewGroup parent, @LayoutRes int itemLayout) {
        super(LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false));

        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    protected final void bindView(T item, int position) {
        this.item = item;
        onBindView(this.item, position);
    }

    protected abstract void onClick(View view, T item);
    protected abstract void onBindView(T item, int position);

    @Override
    public void onClick(View view) {
        onClick(view, item);
    }
}
