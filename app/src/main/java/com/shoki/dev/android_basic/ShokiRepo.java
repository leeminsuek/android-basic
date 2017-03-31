package com.shoki.dev.android_basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shoki on 2017. 3. 30..
 */

public class ShokiRepo {

    public static List<Shoki> getItems() {
        List<Shoki> result = new ArrayList<>();
        result.add(new Shoki(1, "민쇼기1", ""));
        result.add(new Shoki(2, "민쇼기2", ""));
        result.add(new Shoki(3, "민쇼기3", ""));
        result.add(new Shoki(4, "민쇼기4", ""));
        result.add(new Shoki(5, "민쇼기5", ""));
        result.add(new Shoki(6, "민쇼기6", ""));
        result.add(new Shoki(7, "민쇼기7", ""));
        result.add(new Shoki(8, "민쇼기8", ""));
        result.add(new Shoki(9, "민쇼기9", ""));
        result.add(new Shoki(10, "민쇼기10", ""));
        result.add(new Shoki(11, "민쇼기11", ""));
        result.add(new Shoki(12, "민쇼기22", ""));
        result.add(new Shoki(13, "민쇼기33", ""));
        result.add(new Shoki(14, "민쇼기44", ""));
        return result;
    }

    public static List<Shoki> getItemsSortById() {
        List<Shoki> result = getItems();
        Collections.sort(result, (shoki, t1) -> t1.getId() - shoki.getId());

        return result;
    }

    public static List<Shoki> getItemsSortByName() {
        List<Shoki> result = getItems();
        Collections.sort(result, (shoki, t1) -> t1.getName().compareTo(shoki.getName()));

        return result;
    }
}
