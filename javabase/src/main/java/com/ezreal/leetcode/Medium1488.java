package com.ezreal.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Medium1488 {
    public static void main(String[] args) {
        int[] ints = avoidFlood(new int[]{1,0,2,0,2,1});
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }

    /*public static int[] avoidFlood(int[] rains) {
        Set<Integer> pool = new HashSet<>();
        int[] result = new int[rains.length];
        Arrays.fill(result, 1);
        int i = 0;
        int j = 0;
        do {
            if (rains[i] == 0) {
                i++;
                continue;
            }else {
                if (pool.contains(rains[i])) {
                    if (rains[j] != 0) {
                        j++;
                    }else {
                        result[j] = rains[i];
                        result[i] = -1;
                        pool.remove(rains[i]);
                        i++;
                        j++;
                    }
                }else {
                    pool.add(rains[i]);
                    result[i] = -1;
                    i++;
                }
            }
        }while (j<=i&& i< rains.length);
        if (j > i){
            return new int[0];
        }
        return result;
    }*/

    public static int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        AtomicBoolean flag = new AtomicBoolean(false);
        List<Integer> st = new ArrayList<>();
        Map<Integer, List<Integer>> mp =  new HashMap<>();

        Arrays.fill(result, 1);
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                st.add(i);
            }else {
                List<Integer> orDefault = mp.getOrDefault(rains[i], new ArrayList<>());
                orDefault.add(i);
                mp.put(rains[i], orDefault);
                result[i] = -1;
            }
        }
        mp.forEach((k,v)->{
            for (int i = 1; i < v.size(); i++) {
                int finalI = i;
                List<Integer> collect = st.stream().filter(p -> p < v.get(finalI) && p > v.get(finalI-1)).collect(Collectors.toList());
                if (collect.isEmpty()){
                    flag.set(true);
                    return;
                }
                Integer integer = collect.get(collect.size()-1);
                st.remove(integer);
                result[integer] = k;
            }
        });

        if (flag.get()){
            return new int[0];
        }
        return result;
    }
}
