package com.ezreal.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Medium1488 {
    public static void main(String[] args) {
//        int[] ints = {1, 2, 3, 4};
        int[] ints = {1,2,0,0,2,1};
//        int[] ints = {1,2,0,1,2};
        int[] res = avoidFlood(ints);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        TreeSet<Integer> st = new TreeSet<>();
        Arrays.fill(result, 1);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0){
                st.add(i);
            }else {
                if (mp.containsKey(rains[i])){
                    Integer tt = st.higher(mp.get(rains[i]));
                    if (Objects.isNull(tt)){
                        return new int[0];
                    }
                    result[tt] = rains[i];
                    st.remove(tt);
                }
                result[i] = -1;
                mp.put(rains[i], i);
            }
        }
        return result;
    }

    /*public static int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        AtomicBoolean flag = new AtomicBoolean(false);
        List<Integer> st = new ArrayList<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        TreeSet<Integer> st2 = new TreeSet<Integer>();

        Arrays.fill(result, 1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                st.add(i);
            } else {
                List<Integer> orDefault = mp.getOrDefault(rains[i], new ArrayList<>());
                orDefault.add(i);
                mp.put(rains[i], orDefault);
                result[i] = -1;
            }
        }
        mp.forEach((k, v) -> {
            for (int i = 1; i < v.size(); i++) {
                int finalI = i;
                List<Integer> collect = st.stream().filter(p -> p < v.get(finalI) && p > v.get(finalI - 1)).collect(Collectors.toList());
                if (collect.isEmpty()) {
                    flag.set(true);
                    return;
                }
                if (collect.size() == 1) {
                    Integer integer = collect.get(0);
                    st.remove(integer);
                    result[integer] = k;
                    v.remove(finalI);
                    return;
                }
                // 遍历 collect 
                
                if (collect.isEmpty()) {
                    flag.set(true);
                    return;
                } else {
                    Integer integer = collect.get(0);
                    result[integer] = k;
                    v.remove(finalI);
                    st.remove(integer);
                }
            }
        });
        if (flag.get()) {
            return new int[0];
        }
        return result;
    }*/
}
