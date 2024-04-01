package com.ezreal.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Medium849 {

    public static void main(String[] args) {
        //使用一个容器装载100个数字，通过Stream并行处理的方式将容器中为单数的数字转移到容器parallelList
        List<Integer> integerList= new ArrayList<Integer>();
        Medium849 mdeium849 = new Medium849();
        for (int i = 0; i <100; i++) {
            integerList.add(i);
        }

//        List<Integer> parallelList = new ArrayList<Integer>() ;

        List<Integer> parallelList = Lists.newCopyOnWriteArrayList();
        integerList.stream()
                .parallel()
                .filter(i->i%2==1)
                .forEach(i->{
                        parallelList.add(i);
                });

        System.out.println(parallelList);


    }


    public static int maxDistToClosest(int[] seats) {
        int max = 1;

        for (int i = 0; i < seats.length; i++) {

        }
        return max;
    }


}
