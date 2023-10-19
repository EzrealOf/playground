package com.ezreal.leetcode;
//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和
//d 都是 nums 中的元素，且 a != b != c != d 。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
//
//
// 示例 2：
//
//
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 10⁴
// nums 中的所有元素 互不相同
//
//
// Related Topics 数组 哈希表 👍 50 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Medium1726 {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192}));
    }


    public static int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                mp.put(key, mp.getOrDefault(key, 0) + 1);
            }
        }
        AtomicReference<Integer> count = new AtomicReference<>(0);
       mp.values().forEach(v->{
           if (v > 1){
               int factorial = factorial(v, 2);
               count.updateAndGet(v1 -> v1 + factorial);
           }
       });
       return count.get() * 8;

    }


    private static int factorial(int n, int m){
        int result = 1;
        for (int i = 1; i <= m; i++) {
            result *= (n - i + 1);
        }
        for (int i = 1; i <= m; i++) {
            result /= i;
        }
        return result;
    }
}
