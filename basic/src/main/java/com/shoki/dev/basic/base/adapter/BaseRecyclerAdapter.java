package com.shoki.dev.basic.base.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shoki on 2017. 3. 21..
 */

public abstract class BaseRecyclerAdapter<ITEM, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IRecyclerModel<ITEM>, IRecycleListener {

    private List<ITEM> items = new ArrayList<>();

    private OnItemClickListener onItemClickListener = null;

    @Override
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public abstract int onItemViewType(int position);

    @Override
    public int getItemViewType(int position) {
        return onItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void addItem(ITEM item) {
        items.add(item);
    }

    @Override
    public void addItem(ITEM item, int position) {
        items.add(position, item);
    }

    @Override
    public void addItems(List<ITEM> items) {
        this.items = items;
    }

    @Override
    public List<ITEM> getItems() {
        return items;
    }

    @Override
    public ITEM getItem(int position) {
        return items.get(position);
    }

    @Override
    public void removeItem(ITEM item) {
        items.remove(item);
    }

    @Override
    public void removeItem(int position) {
        items.remove(position);
    }

    @Override
    public void clear() {
        items.clear();
    }
}
