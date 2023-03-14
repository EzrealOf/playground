package com.ezreal.bill;

import org.apache.commons.lang3.StringUtils;

public class BillStringTest {

    public static void main(String[] args) {
        System.out.println(fuzzyMatch("大搜⻋", "搜⻋"));
        System.out.println(fuzzyMatch("大搜⻋", "搜"));
        System.out.println(fuzzyMatch("大搜⻋", "sou"));
    }


    public static boolean fuzzyMatch(String query, String name) {
        boolean contains = StringUtils.contains(query, name);

        return contains;
    }
}
