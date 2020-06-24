package com.ezreal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Ezreal
 * <p>
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 * <p>
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple581 {
    public static void main(String[] args) {
//        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums = {1,2,3,4};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != clone[i]) {
                min = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != clone[i]) {
                max = i;
                break;
            }
        }
        return max - min + 1;
    }

}
