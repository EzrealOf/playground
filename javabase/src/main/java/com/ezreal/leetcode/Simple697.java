package com.ezreal.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * <p>
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * <p>
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 通过次数27,600提交次数50,225
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ezeal
 */
public class Simple697 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        AtomicInteger maxCount = new AtomicInteger(-1);
        AtomicInteger maxNumber = new AtomicInteger(-1);
        map.forEach((key, value) -> {
            if (value > maxCount.get()) {
                maxCount.set(value);
                maxNumber.set(key);
            }
        });
        int pre = -1;
        int lat = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxNumber.get() == nums[i] && pre == -1) {
                pre = i;
            }
            if (maxNumber.get() == nums[i]) {
                lat = i;
            }
        }
        return lat - pre;
    }
}
