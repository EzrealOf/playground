package com.ezreal.base;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Simple {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusMonths(-1);
        LocalDate end = localDate.withDayOfMonth(localDate.lengthOfMonth());
        LocalDate start = end.plusDays(-7);
        String f = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String t = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        LocalDateTime fromDateTime = LocalDateTime.of(LocalDate.parse(f, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.MIN);
        LocalDateTime toLocalDateTime = LocalDateTime.of(LocalDate.parse(t, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.MIN);
        int days = Period.between(fromDateTime.toLocalDate(), toLocalDateTime.toLocalDate()).getDays();
        System.out.println();
    }
}
