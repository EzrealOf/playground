package com.ezreal.leetcode;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Medium274 {

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3,0,6,3,1,5}));
    }


    public static int hIndex(int[] citations) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int citation : citations) {
            mp.merge(citation, 1, Integer::sum);
        }
        int result = citations.length;
        while (result >= 0){
            int value = totalCount(mp, result);
            if (value >= result){
                return result;
            }
            result--;
        }
        return result;
    }

    private static Integer totalCount(TreeMap<Integer, Integer> mp, Integer key){
        SortedMap<Integer, Integer> map = mp.tailMap(key);
        return map.values().stream().mapToInt(Integer::intValue).sum();
    }
}
