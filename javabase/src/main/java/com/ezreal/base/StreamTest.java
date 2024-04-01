package com.ezreal.base;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> collect = Optional.ofNullable(Lists.newArrayList("123")).orElse(Lists.newArrayList()).stream().map(s -> s).collect(Collectors.toList());
        List<String> b = null;
        List<String> collect2 = Optional.ofNullable(b).orElse(Lists.newArrayList("345")).stream().map(s -> s).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(collect2);
    }
}
