package com.ezreal.leetcode;

import java.util.PriorityQueue;

public class Hard2003 {

    public static void main(String[] args) {
        smallestMissingValueSubtree(new int[]{-1, 2, 0, 1, 0}, new int[]{1, 2, 3, 4, 5, 6, 7});
    }


    public static int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        return null;

    }

    private int[] tree(int[] parents, int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();


        return null;
    }


    private int currentMin(PriorityQueue<Integer> queue, int result) {
        if (queue.isEmpty()) {
            return -1;
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (result < poll) {
                return result;
            }
            result++;
        }
        return result;
    }
}
