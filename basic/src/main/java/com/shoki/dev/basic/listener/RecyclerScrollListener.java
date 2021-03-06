package com.shoki.dev.basic.listener;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/***
 *
 * Recycler뷰 스크롤 리스너
 *
 * # : OnRecyclervScrollListener
 */
public abstract class RecyclerScrollListener extends RecyclerView.OnScrollListener {

    public static enum LAYOUT_MANAGER_TYPE {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    protected LAYOUT_MANAGER_TYPE layoutManagerType;
    private int[] lastPositions;
    private int lastVisibleItemPosition;
    private int currentScrollState = 0;

    public interface OnRecyclerScrollGetY {
        public void onScrollGetY(int y);
    }

    public interface OnRecyclervLoadMore {
        public void onLoadMore();
    }

    public RecyclerScrollListener() {};

    public RecyclerScrollListener(OnRecyclerScrollGetY listener) {
        onRecyclerScrollGetY = listener;
    }

    public void clearCache() {
        scrolledDistance = 0;
    }


    public void setLayoutManagerType(LAYOUT_MANAGER_TYPE layoutManagerType) {
        this.layoutManagerType = layoutManagerType;
    }

    public OnRecyclervLoadMore getOnRecyclervLoadMore() {
        return onRecyclervLoadMore;
    }

    public void setOnRecyclervLoadMore(OnRecyclervLoadMore onRecyclervLoadMore) {
        this.onRecyclervLoadMore = onRecyclervLoadMore;
    }

    OnRecyclervLoadMore onRecyclervLoadMore;
    OnRecyclerScrollGetY onRecyclerScrollGetY;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //  int lastVisibleItemPosition = -1;
        if (layoutManagerType == null) {
            if (layoutManager instanceof LinearLayoutManager) {
                layoutManagerType = LAYOUT_MANAGER_TYPE.LINEAR;
            } else if (layoutManager instanceof GridLayoutManager) {
                layoutManagerType = LAYOUT_MANAGER_TYPE.GRID;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                layoutManagerType = LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
            } else {
                throw new RuntimeException(
                        "Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
            }
        }

        switch (layoutManagerType) {
            case LINEAR:
                lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                        .findLastVisibleItemPosition();
                break;
            case GRID:
                lastVisibleItemPosition = ((GridLayoutManager) layoutManager)
                        .findLastVisibleItemPosition();
                break;
            case STAGGERED_GRID:
                StaggeredGridLayoutManager staggeredGridLayoutManager
                        = (StaggeredGridLayoutManager) layoutManager;
                if (lastPositions == null) {
                    lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                }
                staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                lastVisibleItemPosition = findMax(lastPositions);
                break;
        }


        if(onRecyclerScrollGetY != null) {
            scrolledDistance += dy;
            if(scrolledDistance < 0) {
                clearCache();
            }
            onRecyclerScrollGetY.onScrollGetY(scrolledDistance);
        }
    }

    private int scrolledDistance = 0;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        currentScrollState = newState;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        if ((visibleItemCount > 0 && currentScrollState == RecyclerView.SCROLL_STATE_IDLE &&
                (lastVisibleItemPosition) >= totalItemCount - 1)) {
            if(onRecyclervLoadMore != null) {
                onRecyclervLoadMore.onLoadMore();
            }
        }
    }

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}