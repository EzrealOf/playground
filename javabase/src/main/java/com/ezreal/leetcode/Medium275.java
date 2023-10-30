package com.ezreal.leetcode;

public class Medium275 {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
    }


    public static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return citations.length - left;

    }


}
