package com.shoki.dev.basic.base.adapter;

import java.util.List;

/**
 * Created by shoki on 2017. 3. 23..
 */

public interface IRecyclerModel<T> {

    public void addItem(T item);
    public void addItem(T item, int position);
    public void addItems(List<T> items);

    public T getItem(int position);
    public List<T> getItems();

    public void removeItem(T item);
    public void removeItem(int position);

    public void clear();

    public int getItemCount();
}
