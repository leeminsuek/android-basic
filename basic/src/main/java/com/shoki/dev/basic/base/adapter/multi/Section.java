package com.shoki.dev.basic.base.adapter.multi;

import java.util.ArrayList;
import java.util.List;

public class Section {
    private int sectionType;
    private boolean isDataRemains = false;

    private List<RecyclerRow<?>> items = new ArrayList<>();
    private List<RecyclerRow<?>> header = new ArrayList<>();
    private List<RecyclerRow<?>> footer = new ArrayList<>();

    public Section(List<RecyclerRow<?>> item, int sectionType) {
        this.sectionType = sectionType;

        for (int i = 0; i < item.size(); i++) {
            RecyclerRow<?> row = item.get(i);
            row.setSectionType(sectionType);
            if (row.getLocation() == RecyclerRow.Location.HEADER) {
                header.add(row);
            } else if (row.getLocation() == RecyclerRow.Location.FOOTER) {
                footer.add(row);
            } else {
                items.add(row);
            }
        }
    }

    public void addItems(List<RecyclerRow<?>> items) {
        for (int i = 0; i < items.size(); i++) {
            RecyclerRow<?> row = items.get(i);
            row.setSectionType(sectionType);
            if (row.getLocation() == RecyclerRow.Location.HEADER) {
                header.add(row);
            } else if (row.getLocation() == RecyclerRow.Location.FOOTER) {
                footer.add(row);
            } else {
                this.items.add(row);
            }
        }
    }

    public boolean isDataRemains() {
        return isDataRemains;
    }

    public void setDataRemains(boolean dataRemains) {
        isDataRemains = dataRemains;
        if(dataRemains) {
            RecyclerRow row = RecyclerRow.create("loadingFooter", BaseSectionRecyclerAdapter.MULTI_VIEW_TYPE_LOADING_FOOTER, RecyclerRow.Location.FOOTER);
            row.setSectionType(getSectionType());
            footer.add(0, row);
        } else {
            RecyclerRow deleteRow = null;
            for(RecyclerRow row : footer) {
                if(row.getViewType() == BaseSectionRecyclerAdapter.MULTI_VIEW_TYPE_LOADING_FOOTER) {
                    deleteRow = row;
                    break;
                }
            }
            if(deleteRow != null) {
                footer.remove(deleteRow);
            }
        }
    }

    public List<RecyclerRow<?>> getItems() {
        return items;
    }

    public int getSectionType() {
        return sectionType;
    }

    public List<RecyclerRow<?>> getHeader() {
        return header;
    }

    public List<RecyclerRow<?>> getFooter() {
        return footer;
    }



//    public static Section create(List<RecyclerRow<?>> item, int sectionType) {
//        return new Section(item, sectionType, isLoadingFooter);
//    }

    public static Section create(List<RecyclerRow<?>> item, int sectionType) {
        return new Section(item, sectionType);
    }

}