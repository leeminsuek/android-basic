package com.shoki.dev.basic.base.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by shoki on 2017. 3. 23..
 */

public interface OnItemClickListener {
    public void onItemClick(RecyclerView.Adapter<?> adapter, int position);
}
