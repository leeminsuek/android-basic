package com.shoki.dev.basic.base.adapter.multi;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.shoki.dev.basic.listener.RecyclerBottomListener;

/**
 * Created by shoki on 2017. 5. 17..
 */

public class LoadMoreRecyclerView extends RecyclerView {

    private boolean isDataRemains = true;
    private BaseSectionRecyclerAdapter mAdapter;
    private RecyclerBottomListener mBottomListener;
    public LoadMoreRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
//                if (lastVisibleItem == mAdapter.getSectionTotalCount() - 1 && isDataRemains) {
//                    isDataRemains = false; // 요청 콜 한 번만 하기 위함
//                    mAdapter.setDataRemains(isDataRemains);
//                    if(mBottomListener != null) {
//                        mBottomListener.onBottom();
//                    }
//                }


                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = mAdapter.getSectionTotalCount()-1;
                if ((visibleItemCount > 0 &&
                        (lastVisibleItem) >= totalItemCount - 1) && isDataRemains) {
                    if(mBottomListener != null) {
                        isDataRemains = false;
                        mAdapter.setDataRemains(true);
                        mBottomListener.onBottom();
                        mAdapter.notifyItemChanged(mAdapter.getItemCount());
                    }
                }
            }
        });

    }


    public void setDataRemains(boolean dataRemains) {
        this.isDataRemains = dataRemains;
        mAdapter.setDataRemains(!isDataRemains);
    }

    public void setBottomListener(RecyclerBottomListener mBottomListener) {
        this.mBottomListener = mBottomListener;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        this.mAdapter = (BaseSectionRecyclerAdapter) adapter;
    }
}
