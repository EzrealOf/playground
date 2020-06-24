package com.ezreal.collection;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ezreal
 */
public class CollectionTest {

    public static void main(String[] args) {
//        listTest();
        listTest2();

    }

    public static void listTest() {
        List<String> stringList = Lists.newArrayList("1", "2", "3", "4", "5");
        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("2".equals(next)) {
                iterator.remove();
            }
        }
        System.out.println(stringList.toString());
    }

    public static void listTest2() {
        List<String> stringList = Lists.newArrayList("1", "2", "3", "4", "5", "5", "5");
        List<String> collect = stringList.parallelStream().distinct().collect(Collectors.toList());
        System.out.println(collect.toString());
    }

}
