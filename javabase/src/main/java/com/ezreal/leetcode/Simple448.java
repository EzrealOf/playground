package com.ezreal.leetcode;

import java.util.*;

/**
 * @author Ezreal
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Simple448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
//        int[] nums = {};
//        int[] nums = {2, 2};
        List<Integer> result = findDisappearedNumbersWhitNoSpace(nums);
        System.out.println(result);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int min = 1;
        int max = min + nums.length - 1;
        Set<Integer> hashSet = new HashSet<>();
        for (int i = min; i <= max; i++) {
            hashSet.add(i);
        }
        for (int num : nums) {
            hashSet.remove(num);
        }
        return new ArrayList<>(hashSet);
    }

    public static List<Integer> findDisappearedNumbersWhitNoSpace(int[] nums) {
        //用来存放结果
        List<Integer> res = new ArrayList<>();
        //1. 遍历下数组的元素，对对应的索引位置的元素作标记
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //由于数组的元素有可能被*-1，所以取绝对值
            int num = Math.abs(nums[i]);
            int index = num - 1;
            if (nums[index] > 0) {
                nums[index] *= -1;
            }
        }
        // 寻找没有标记的索引位置
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                //将索引转化为对应的元素
                int num = i + 1;
                res.add(num);
            }
        }
        return res;
    }
}
