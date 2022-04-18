package com.ezreal.car;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Lottery {

    public static List<String> input(String take, int[] nums, int[] letters) {
        List<String> carNumbers = Lists.newArrayList();
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                StringBuffer stringBuffer = new StringBuffer(take);
                stringBuffer.deleteCharAt(nums[0]);
                stringBuffer.insert(nums[0], i);
                stringBuffer.deleteCharAt(nums[1]);
                stringBuffer.insert(nums[1], j);
                carNumbers.add(stringBuffer.toString());
//                System.out.println(stringBuffer);
            }

        }
        return carNumbers;
    }

    public static List<String> filter(List<String> carNumbers) {
        List<String> result = Lists.newArrayList(carNumbers);
        for (int i = 0; i < carNumbers.size(); i++) {
            String s = carNumbers.get(i);
            char c = s.charAt(4);
            if (c == '0' || c == '5' || c == '1' || c == '9' ){
                result.remove(s);
            }
        }
        return result;
    }

    public static void filterOther(List<String> carNumbers, List<String> exList){
        for (String ex : exList) {
            carNumbers.remove(ex);
        }
    }

    public static void printCarNumbers(List<String> carNumbers) {

        int j = 0;

        for (int i = 0; i < carNumbers.size(); i++) {
            System.out.print(carNumbers.get(i) + '\t');
            j++;
            if (j % 15 == 0 && j != 0) {
                j = 0;
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int[] a = new int[2];
        a[0] = 2;
        a[1] = 4;
        List<String> carNumbers = input("A10K0Z", a, null);
        carNumbers.addAll(input("A60K0T", a, null));
        carNumbers.addAll(input("A00J0Z", a, null));
        carNumbers.addAll(input("A00J0Q", a, null));
        carNumbers.addAll(input("A90J0W", a, null));
        carNumbers.addAll(input("A50J0G", a, null));


        List<String> filter = filter(carNumbers);

        List<String> exList = Lists.newArrayList("A66K3T","A60K6T","A11K8Z","A58J8G","A58J7G","A58J6G","A58J8M","A57J7M","A57J8G","A98J3W","A98J6W","A98J2W","A66K8T","A60K6T","A61K6T");

        filterOther(filter, exList);
        printCarNumbers(filter);



    }


}
