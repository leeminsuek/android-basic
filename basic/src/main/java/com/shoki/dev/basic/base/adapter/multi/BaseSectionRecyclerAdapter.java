package com.shoki.dev.basic.base.adapter.multi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shoki.dev.basic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shoki on 2017. 5. 17..
 */

public abstract class BaseSectionRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public final static int MULTI_VIEW_TYPE_LOADING_FOOTER = 9999;

    private List<RecyclerRow<?>> mRecyclerRows = new ArrayList<>();
    protected List<Section> mSections;
    private boolean isDataRemains = false;
    protected OnRecyclerItemClickListener mRecyclerItemClickListener;

    public abstract BaseViewHolder onAbstractCreateViewHolder(ViewGroup parent, int viewType);

    public void setRecyclerItemClickListener(OnRecyclerItemClickListener mRecyclerItemClickListener) {
        this.mRecyclerItemClickListener = mRecyclerItemClickListener;
    }

    public boolean isDataRemains() {
        return isDataRemains;
    }

    public void setDataRemains(boolean dataRemains) {
        isDataRemains = dataRemains;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == MULTI_VIEW_TYPE_LOADING_FOOTER) {
            return new LoadingFooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_loading_footer, parent, false));
        } else {
            return onAbstractCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if(isLoadingFooter(position)) {

        } else {
            Section section = getSection(position);
            holder.onBindViewHolder(getItem(position), position, getSection(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(isLoadingFooter(position)) {
            return MULTI_VIEW_TYPE_LOADING_FOOTER;
        }
        return mRecyclerRows.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        if(mRecyclerRows.size() > 0 && isDataRemains) {
            return mRecyclerRows.size() + 1;
        }
        return mRecyclerRows.size();
    }

    public int getSectionTotalCount() {
        int count = 0;
        for(Section section : mSections) {
            count += section.getItems().size();
        }
//        for(RecyclerRow row : mRecyclerRows) {
//            if(row.getLocation() == RecyclerRow.Location.ITEM) {
//                count++;
//            }
//        }
        return count;
    }

    /**
     * By sectionType Section
     * @param sectionType
     * @return
     */
    public Section getSectionForType(int sectionType) {
        for(Section section : mSections) {
            if(section.getSectionType() == sectionType) {
                return section;
            }
        }
        return null;
    }

    /**
     * By position Section
     * @param position
     * @return
     */
    public Section getSection(int position) {
        for(Section section : mSections) {
            if(section.getSectionType() == mRecyclerRows.get(position).getSectionType()) {
                return section;
            }
        }
        return null;
    }

    /**
     * By sectionType sectionCount
     * @param sectionType
     * @return
     */
    public int getSectionCount(int sectionType) {
        if(mSections == null) return 0;
        for(Section section : mSections) {
            if(sectionType == section.getSectionType()) {
                return section.getItems().size();
            }
        }
        return 0;
    }

    /**
     * use loadingfooter
     * @param position
     * @return
     */
    protected boolean isLoadingFooter(int position) {
        if(mRecyclerRows.size() == position && isDataRemains) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * By Section Last Item Position
     * @param section
     * @return
     */
    public int getSectionLastItemPosition(Section section) {
        int i = 0;
        for(Section sectionItem : mSections) {
            if(sectionItem.getSectionType() == section.getSectionType()) {
                mSections.set(i, section);
                break;
            }
            i++;
        }

        int index = -1;
        for(int k = 0; k < mRecyclerRows.size(); k++) {
            if(mRecyclerRows.get(k).getSectionType() == section.getSectionType()) {
                index = k;
            }
        }
        return index;
    }

    /**
     * Section update
     * @param section
     */
    public void setSection(Section section) {
        int index = getSectionLastItemPosition(section);
        for(int i = 0 ; i < mSections.size();i ++) {
            if(mSections.get(i).getSectionType() == section.getSectionType()) {
                mSections.get(i).setDataRemains(section.isDataRemains());
            }
        }
        if(index != -1) {
            if(section.getFooter() != null) {
                for(RecyclerRow<?> row : section.getFooter()) {
                    if(row.getViewType() == MULTI_VIEW_TYPE_LOADING_FOOTER) {
                        mRecyclerRows.add(index+1, row);
                        break;
                    }
                }
            }
        }
    }

    /**
     * By sectionType Section in Item add
     * @param items
     * @param sectionType
     */
    public void addSectionItems(List<RecyclerRow<?>> items, int sectionType) {
        Section section = getSectionForType(sectionType);

        int index = getSectionLastItemPosition(section);
        for(int i = 0 ; i < mSections.size();i ++) {
            if(mSections.get(i).getSectionType() == section.getSectionType()) {
                mSections.get(i).setDataRemains(false);
                mSections.get(i).addItems(items);
            }
        }

        if(index != -1) {
            if(items != null) {
                for(RecyclerRow<?> row : items) {
                    mRecyclerRows.add(index++, row);
                }
            }
            RecyclerRow deleteRow = null;
            for(RecyclerRow<?> row : mRecyclerRows) {
                if(section.getSectionType() == row.getSectionType() &&
                        row.getViewType() == MULTI_VIEW_TYPE_LOADING_FOOTER) {
                    deleteRow = row;
                }
            }
            if(deleteRow != null) {
                mRecyclerRows.remove(deleteRow);
            }
        }
    }

    /**
     * Section List add
     * @param sections
     */
    public void addSections(List<Section> sections) {
        mSections = sections;

        for(Section section : sections) {
            if(section.getHeader() != null) {
                for(RecyclerRow<?> row : section.getHeader()) {
                    mRecyclerRows.add(row);
                }
            }

            if(section.getItems() != null) {
                for(RecyclerRow<?> row : section.getItems()) {
                    mRecyclerRows.add(row);
                }
            }

            if(section.getFooter() != null) {
                for(RecyclerRow<?> row : section.getFooter()) {
                    mRecyclerRows.add(row);
                }
            }
        }
    }

    public void addSection(Section section) {
        mSections.add(section);

        if(section.getHeader() != null) {
            for(RecyclerRow<?> row : section.getHeader()) {
                mRecyclerRows.add(row);
            }
        }

        if(section.getItems() != null) {
            for(RecyclerRow<?> row : section.getItems()) {
                mRecyclerRows.add(row);
            }
        }

        if(section.getFooter() != null) {
            for(RecyclerRow<?> row : section.getFooter()) {
                mRecyclerRows.add(row);
            }
        }
    }

    /***
     * Section clear
      */
    public void clear() {
        mRecyclerRows.clear();
    }

    /**
     * get Section In Item
     * @param position
     * @param <ITEM>
     * @return
     */
    public <ITEM> ITEM getItem(int position) {
        return (ITEM) mRecyclerRows.get(position).getItem();
    }


}
