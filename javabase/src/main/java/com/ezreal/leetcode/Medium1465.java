package com.ezreal.leetcode;

import java.util.Arrays;

public class Medium1465 {

    public static void main(String[] args) {
        maxArea(10, 4, new int[]{1, 2}, new int[]{1, 3});
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] horizontalCutsResult = getCut(horizontalCuts, h);
        int[] verticalCutsResult = getCut(verticalCuts, w);
        long s = getMax(horizontalCutsResult);
        long v = getMax(verticalCutsResult);
        long l = s * v;
        return (int) (l % 1000000007);
    }


    private static int[] getCut(int[] cuts, int max) {
        int[] result = new int[cuts.length+1];
        Arrays.sort(cuts);
        for (int i = 0; i < cuts.length; i++) {
            if (i == 0){
                result[i] = cuts[i];
                continue;
            }
            result[i] = cuts[i] - cuts[i-1];
        }
        result[cuts.length] = max - cuts[cuts.length-1];
        return result;
    }

    private static Long getMax(int[] cuts){
        long max = 0;
        for (int i = 0; i < cuts.length; i++) {
            max = Math.max(max, cuts[i]);
        }
        return max;
    }
}
