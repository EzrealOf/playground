package com.ezreal.leetcode;

public class Easy2562 {
    public static void main(String[] args) {
        int[] nums = {5,14,13,8,12};
        System.out.println(findTheArrayConcVal(nums));
    }



    public static long findTheArrayConcVal(int[] nums) {
        long result = 0;
        int i = 0;
        int j = nums.length - 1;
        do {
            if (i == j) {
                result += nums[i];
                i++;
                j--;
                continue;
            }
            String pre = String.valueOf(nums[i]);
            String next = String.valueOf(nums[j]);
            result += Integer.parseInt(pre + next);
            i++;
            j--;
        } while (i <= j);
        return result;
    }
}
