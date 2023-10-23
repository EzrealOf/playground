package com.ezreal.leetcode;

public class Easy2678 {

    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"9751302862F0693", "3888560693F7262", "5485983835F0649", "2580974299F6042", "9976672161M6561", "0234451011F8013", "4294552179O6482"}));
    }

    public static int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            if (detail.charAt(11) > '6') {
                count++;
            } else if (detail.charAt(11) == '6' && detail.charAt(12) >= '1') {
                count++;
            }
        }
        return count;
    }

}
