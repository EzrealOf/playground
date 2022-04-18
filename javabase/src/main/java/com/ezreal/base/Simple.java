package com.ezreal.base;

import org.apache.commons.lang3.StringUtils;

public class Simple {

    public static void main(String[] args) {
        String s = "";
        boolean blank = StringUtils.isEmpty(s);
        System.out.println(blank);

    }
}
