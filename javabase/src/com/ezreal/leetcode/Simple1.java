package com.ezreal.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ezreal
 * <p>
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Simple1 {
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]){
                    int[] result = new int[]{i, j};
                    return result;
                }
            }
        }
        return new int[0];
    }*/
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsIndexMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (numsIndexMap.containsKey(other)){
                return new int[]{numsIndexMap.get(other), i};
            }else {
                numsIndexMap.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
