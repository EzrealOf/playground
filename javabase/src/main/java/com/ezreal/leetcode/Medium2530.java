package com.ezreal.leetcode;

import java.util.TreeMap;

public class Medium2530 {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }


    public static long maxKelements(int[] nums, int k) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        long result = 0L;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            tm.put(num, tm.getOrDefault(num, 0) + 1);
        }
        do {
            Integer r = tm.lastKey();
            result += r;
            double ceil = Math.ceil(Double.valueOf(r.toString()) / Double.valueOf("3"));
            int m = (int) ceil;
            tm.put(m, tm.getOrDefault(m, 0) + 1);
            Integer t = tm.get(r);
            if (t == 1) {
                tm.remove(r);
            } else {
                tm.put(r, t - 1);
            }
            k--;
        } while (k > 0);
        return result;
    }

}
