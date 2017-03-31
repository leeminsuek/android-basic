package com.shoki.dev.basic.base.adapter;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.shoki.dev.basic.constants.Constants;
import com.shoki.dev.basic.util.SLog;

import java.util.List;

/**
 * Created by shoki on 2017. 3. 22..
 */

public abstract class BaseHeaderRecyclerAdapter<ITEM, HEADER> extends BaseRecyclerAdapter<ITEM, RecyclerView.ViewHolder> {

    private boolean isHeader = false;
    private HEADER headerItem = null;

    public void setHeaderItem(HEADER headerItem) {
        this.headerItem = headerItem;
        isHeader = true;
    }

    public HEADER getHeaderItem() {
        return headerItem;
    }

    protected abstract RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType);
    protected abstract RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType);

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if(viewType == Constants.Recycler.V_TYPE_HEADER) {
            viewHolder = onCreateHeaderViewHolder(parent, viewType);
        } else {
            viewHolder = onCreateItemViewHolder(parent, viewType);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == Constants.Recycler.V_TYPE_HEADER) {
            ((BaseViewHolder<HEADER>) holder).onBindViewHolder(headerItem, position);
        } else {
            int realPosition = getRealItemPosition(position);
            ((BaseViewHolder<ITEM>) holder).onBindViewHolder(getItem(realPosition), realPosition);
        }
    }

    @Override
    public int getItemCount() {
        int size = super.getItemCount();
        if(isHeader) size++;
        return size;
    }

    @Override
    public int onItemViewType(int position) {
        if(hasHeaderItems(position)) {
            return Constants.Recycler.V_TYPE_HEADER;
        }
        return Constants.Recycler.V_TYPE_ITEM;
    }

    public boolean hasHeaderItems(int position) {
        return isHeader && position == 0;
    }

    protected int getRealItemPosition(int position) {
        if(isHeader) {
            return position - 1;
        } else {
            return position;
        }
    }
}