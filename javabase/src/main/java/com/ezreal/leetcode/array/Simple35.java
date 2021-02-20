package com.ezreal.leetcode.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 通过次数319,872提交次数680,312
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 参考资料
 * https://mp.weixin.qq.com/s/fCf5QbPDtE6SSlZ1yh_q8Q
 */
public class Simple35 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
//        int i = searchInsert(nums, 0);
        int i = searchInsert2(nums, 9);
        System.out.println(i);
    }

    /**
     * 暴露破解
     *
     * @param nums   数组
     * @param target 目标
     * @return 对应插入的位置
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     * target 是在一个在左闭右闭的区间里，也就是[left, right]
     */
    public static int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int middle = left + ((right - left) >> 1);
            if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }

        }
        return right + 1;
    }

    /**
     * 二分查找
     * target 是在一个在左闭右开的区间里，也就是[left, right)
     */
    public static int searchInsert3(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len;
        while (left < right) {
            int middle = left + ((right - left) >> 1);
            if (target < nums[middle]) {
                right = middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }else {
                return middle;

            }
        }
        return right;
    }
}
