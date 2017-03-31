package com.shoki.dev.basic.util;

/**
 * Created by shoki on 2017. 3. 29..
 */

public class NumberUtils {

    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }
}
