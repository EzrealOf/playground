package com.ezreal.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Easy136 {

    public static void main(String[] args) {
        int[] ints = {2, 2, 1};
        int number = singleNumber(ints);
        System.out.println(number);
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (st.contains(nums[i])) {

                st.remove(nums[i]);
            } else {
                st.add(nums[i]);
            }
        }
        int res = 0;
        for (Integer integer : st) {
            res = integer;
        }
        return res;
    }
}
