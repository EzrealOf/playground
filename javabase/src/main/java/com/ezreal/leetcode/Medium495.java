package com.ezreal.leetcode;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 * <p>
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 * <p>
 *  
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 * 示例2:
 * <p>
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假定时间序列数组的总长度不超过 10000。
 * 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。
 * 通过次数16,739提交次数31,664
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/teemo-attacking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ezreal
 */
public class Medium495 {
    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries, duration));
    }

    public static int findPoisonedDurationBruteForce(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int[] counts = new int[timeSeries[timeSeries.length - 1] + duration];
        int sum = 0;
        for (int timeSery : timeSeries) {
            for (int j = timeSery; j < timeSery + duration; j++) {
                counts[j] = 1;
            }
        }
        for (int count : counts) {
            if (count == 1) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 攻击时间
     *
     * @param timeSeries 数组
     * @param duration   持续时间
     * @return 返回时间
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        if (timeSeries.length == 0) {
            return sum;
        }
        for (int i = 0; i < timeSeries.length - 1; i++) {
            sum += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return sum + duration;
    }
}
