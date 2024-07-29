package com.ezreal.treeTable;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class TreeTableTest2 {

    public static void main(String[] args) {



        Comparator<Row> rowComparator =  Comparator.comparing(Row::isOther).reversed()
                .thenComparing(Row::getAmount).reversed();

        Comparator<Column> colComparator = Comparator.comparing(Column::isDefault).reversed()
                .thenComparing(Column::getCreateTime);
        TreeBasedTable<Row, Column, BigDecimal> treeBasedTable = TreeBasedTable.create(rowComparator, colComparator);

        Column column1 = Column.builder().columnName("短信").createTime(LocalDateTime.now()).isDefault(false).build();
        Column column2 = Column.builder().columnName("阿里云").createTime(LocalDateTime.now().plusDays(1)).isDefault(false).build();
//        Column column3 = Column.builder().columnName("默认分类").createTime(LocalDateTime.now()).isDefault(true).build();
        Column column3 = Column.builder().columnName("默认分类").createTime(LocalDateTime.now().plusDays(-1L)).isDefault(true).build();

        Row row1 = Row.builder().rowName("基础技术").amount(BigDecimal.valueOf(1000)).isOther(false).build();
        Row row2 = Row.builder().rowName("公共服务").amount(BigDecimal.valueOf(1002)).isOther(false).build();
        Row row3 = Row.builder().rowName("其他").amount(BigDecimal.valueOf(1900)).isOther(true).build();

        ArrayList<Column> columns = Lists.newArrayList(column3, column1, column2);
        ArrayList<Row> rows = Lists.newArrayList(row3, row1, row2);
        for (Row row : rows) {
            for (Column column : columns) {
                treeBasedTable.put(row, column, row.getAmount());
            }
        }


        System.out.println("----colmun---");
        for (Map<Column, BigDecimal> row : treeBasedTable.rowMap().values()) {
            for (Map.Entry<Column, BigDecimal> entry : row.entrySet()) {
                System.out.println(entry.getKey().getColumnName() + ": " + entry.getValue());
            }
        }

        System.out.println("----row---");
        for (Map<Row, BigDecimal> column : treeBasedTable.columnMap().values()) {
            for (Map.Entry<Row, BigDecimal> entry : column.entrySet()) {
                System.out.println(entry.getKey().getRowName() + ": " + entry.getValue());
            }
        }


        System.out.println("----all---");
        // 遍历所有单元格
        for (Table.Cell<Row, Column, BigDecimal> cell : treeBasedTable.cellSet()) {
            System.out.println(cell.getRowKey().getRowName() + ", " + cell.getColumnKey().getColumnName() + ": " + cell.getValue());
        }

        int count = 0;
        for (Table.Cell<Row, Column, BigDecimal> cell : treeBasedTable.cellSet()) {
            count++;
        }
        System.out.println("Total cells: " + count);

    }
}
