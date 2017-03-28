package com.shoki.dev.basic.base.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by shoki on 2017. 3. 23..
 */

public interface IRecycleListener {
    public void setOnItemClickListener(OnItemClickListener listener);

    public void notifyDataSetChanged();
}
