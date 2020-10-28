package com.ezreal.base;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author ezreal
 */
public class Base {
    public static void main(String[] args) {
//        objectTest();
//
//        floatTest();
//
//        bigDecimalTest();
//
//        arraysTest();
//
//        listsTest();

//        queueTest();
        setContainTest();




    }

    /**
     * object equals 使用
     */
    private static void objectTest() {
        Object o1 = null;
        Object o2 = new Object();

        System.out.println(Objects.equals(o1, o2));
    }

    /**
     * float 精度测试比较
     */
    private static void floatTest() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        // 0.100000024
        System.out.println(a);
        // 0.099999964
        System.out.println(b);
        // false
        System.out.println(a == b);
        // false
        System.out.println(Objects.equals(a, b));

    }

    /**
     * bigDecimal 精度测试比较
     */
    private static void bigDecimalTest() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        // 0.1
        BigDecimal x = a.subtract(b);
        // 0.1
        BigDecimal y = b.subtract(c);
        // true
        System.out.println(x.equals(y));

        BigDecimal d = new BigDecimal(0.1);
        BigDecimal e = new BigDecimal("0.1");
        System.out.println(d);
        System.out.println(e);

    }

    /**
     * asList 测试
     */
    private static void arraysTest() {
        String[] a = {"1", "2"};
        List<String> list = Arrays.asList(a);
        System.out.println(list.get(0));
        a[0] = "3";
        System.out.println(list);

        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        //1
        System.out.println(myList.size());
        //数组地址值
        System.out.println(myList.get(0));
        try {
            //报错：ArrayIndexOutOfBoundsException
            System.out.println(myList.get(1));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        int[] array = (int[]) myList.get(0);
        //
        System.out.println(array[0]);
    }

    private static void listsTest() {
        String[] a = {"1", "2"};
        List<String> list = Lists.newArrayList(a);
        System.out.println(list);
        a[0] = "3";
        System.out.println(list);

    }

    private static void queueTest() {
        List<String> elementList = Lists.newArrayList("1", "2", "3");
        Queue<String> elementQueue = Queues.newArrayDeque(elementList);
        if (!elementQueue.isEmpty()) {
            String poll = elementQueue.poll();
            System.out.println(poll);
            elementQueue.offer(poll);
        }
        System.out.println(elementQueue.toString());

    }

    private static void setContainTest(){
        Set<String> aSet = Sets.newHashSet("a","b","c");
        Set<String> bSet = Sets.newHashSet("a");
        System.out.println(aSet.contains(bSet));
        System.out.println(bSet.contains(aSet));
        System.out.println(aSet.containsAll(bSet));
        System.out.println(bSet.containsAll(aSet));
        Set<String> cSet = Sets.newHashSet("a","e");
        System.out.println(aSet.containsAll(cSet));
        System.out.println(cSet.containsAll(aSet));

    }


}
