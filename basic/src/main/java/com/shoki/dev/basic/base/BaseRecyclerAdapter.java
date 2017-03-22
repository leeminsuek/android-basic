package com.shoki.dev.basic.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by shoki on 2017. 3. 21..
 */

public abstract class BaseRecyclerAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {

    private List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T item = items.get(position);
        holder.bindView(item, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
