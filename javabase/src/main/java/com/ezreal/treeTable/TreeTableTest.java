package com.ezreal.treeTable;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class TreeTableTest {

    public static void main(String[] args) {



        Comparator<User> rowComparator =  Comparator.comparing(User::isDefault)
                .thenComparing(User::getCreateTime);

        Comparator<User> colComparator = Comparator.comparing(User::isOther)
                .thenComparing(User::getAmount);
        TreeBasedTable<User, User, BigDecimal> treeBasedTable = TreeBasedTable.create(rowComparator, colComparator);

        User user1 = User.builder().columnName("短信").createTime(LocalDateTime.now()).isDefault(false)
                .rowName("基础技术").amount(BigDecimal.valueOf(1000)).isOther(false)
                .build();
        User user2 = User.builder().columnName("阿里云").createTime(LocalDateTime.now()).isDefault(false)
                .rowName("基础技术").amount(BigDecimal.valueOf(1500)).isOther(false)
                .build();
        User user3 = User.builder().columnName("默认分类").createTime(LocalDateTime.now()).isDefault(true)
                .rowName("基础技术").amount(BigDecimal.valueOf(2500)).isOther(false)
                .build();
        User user4 = User.builder().columnName("默认分类").createTime(LocalDateTime.now()).isDefault(true)
                .rowName("其他").amount(BigDecimal.valueOf(2500)).isOther(true)
                .build();



        treeBasedTable.put(user1, user1, user1.getAmount());
        treeBasedTable.put(user2, user2, user2.getAmount());
        treeBasedTable.put(user3, user3, user3.getAmount());
        treeBasedTable.put(user4, user4, user4.getAmount());

        System.out.println("----row---");
        for (Map<User, BigDecimal> row : treeBasedTable.rowMap().values()) {
            for (Map.Entry<User, BigDecimal> entry : row.entrySet()) {
                System.out.println(entry.getKey().getRowName() + ": " + entry.getValue());
            }
        }

        System.out.println("----column---");
        for (Map<User, BigDecimal> column : treeBasedTable.columnMap().values()) {
            for (Map.Entry<User, BigDecimal> entry : column.entrySet()) {
                System.out.println(entry.getKey().getColumnName() + ": " + entry.getValue());
            }
        }


        System.out.println("----all---");
        // 遍历所有单元格
        for (Table.Cell<User, User, BigDecimal> cell : treeBasedTable.cellSet()) {
            System.out.println(cell.getRowKey().getRowName() + ", " + cell.getColumnKey().getColumnName() + ": " + cell.getValue());
        }


    }
}
