package com.ezreal.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Medium137 {


    public int singleNumber(int[] nums) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> duplicate = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (result.contains(k)) {
                result.remove(k);
                duplicate.add(k);
            }
            if (!duplicate.contains(k)) {
                result.add(k);
            }
        }
        int k = 0;
        for (Integer integer : result) {
            k = integer;
        }
        return k;
    }
}
