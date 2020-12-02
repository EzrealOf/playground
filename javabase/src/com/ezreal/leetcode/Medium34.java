package ezreal.leetcode;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 通过次数182,098提交次数435,324
 */
public class Medium34 {

    public static void main(String[] args) {
//        int[]nums = new int[]{5,7,7,8,8,10};
        int[]nums = new int[]{};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    /**
     * 暴力循环（Brute force）
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRangeBruteForce(int[] nums, int target) {
        //give
        int first = -1;
        int last = -1;
        //when
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && first == -1) {
                first = i;
            }
            if (nums[i] == target) {
                last = i;
            }
        }
        //then
        return new int[]{first, last};
    }

    /**
     * 二分查找（Binary search）
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        //give
        int first = -1;
        int last = -1;
        //when 二分查找

        //then
        return new int[]{first, last};
    }
}
