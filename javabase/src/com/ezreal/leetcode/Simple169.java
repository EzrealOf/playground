package com.ezreal.leetcode;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ezreal
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple169 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 4};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Long> maxMap = new HashMap<>();
        Long max = 0L;
        int maxNumber = nums[0];
        for (int i = 0; i < nums.length; i++) {
            Long number = maxMap.getOrDefault(nums[i], 1L);
            if (maxMap.containsKey(nums[i])) {
                number++;
                maxMap.put(nums[i], number);
            }
            maxMap.put(nums[i], number);

            if (max < number) {
                max = number;
                maxNumber = nums[i];
            }
        }
        return maxNumber;
    }
}
