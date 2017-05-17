package com.shoki.dev.basic.base.adapter.multi;

public class RecyclerRow<ITEM> {
    public enum Location {
        FOOTER,
        HEADER,
        ITEM
    }

    private ITEM item;
    private int viewType;
    private int sectionType;
    private Location location;

    public RecyclerRow(ITEM item, int viewType, Location location) {
        this.viewType = viewType;
        this.item = item;
        this.location = location;
    }
    public void setItem(ITEM item) {
        this.item = item;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getSectionType() {
        return sectionType;
    }

    public void setSectionType(int sectionType) {
        this.sectionType = sectionType;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getViewType() {
        return viewType;
    }

    public ITEM getItem() {
        return item;
    }

    public Location getLocation() {
        return location;
    }

    public static <T> RecyclerRow<T> create(T item, int viewType, Location location) {
        return new RecyclerRow<>(item, viewType, location);
    }
}