package com.ezreal.leetcode;

import java.util.*;

/**
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 通过次数40,595提交次数114,185
 *
 * @author ezeal
 */
public class Simple414 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMaxSet(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        List<Integer> arrayList = new ArrayList<>(hashSet);
        Collections.sort(arrayList);
        if (arrayList.size() < 3) {
            return arrayList.get(arrayList.size() - 1);
        } else {
            return arrayList.get(arrayList.size() - 3);
        }
    }

    public static int thirdMax(int[] nums) {
        int biggest = Integer.MIN_VALUE;
        int bigger = Integer.MIN_VALUE;
        int big = Integer.MIN_VALUE;
        int count = 0;
        boolean init = true;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (init) {
                //初始化状态。
                count++;
                big = bigger;
                bigger = biggest;
                biggest = nums[i];
                init = false;
            } else {
                //后续如果有更大 就替换
                if (nums[i] > biggest) {
                    count++;
                    big = bigger;
                    bigger = biggest;
                    biggest = nums[i];
                }
            }

        }
        return count > 2 ? big : biggest;
    }
}
