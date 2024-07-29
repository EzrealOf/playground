package com.ezreal.base;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.math.BigDecimal;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Table<String, String, Integer> table = HashBasedTable.create();

        // 添加数据
        table.put("row1", "col1", 1);
        table.put("row1", "col2", 2);

        // 获取数据
        Integer value = table.get("row1", "col1");
        System.out.println(value); // 输出 1

        for (Map<String, Integer> row : table.rowMap().values()) {
            for (Map.Entry<String, Integer> entry : row.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        for (Map<String, Integer> column : table.columnMap().values()) {
            for (Map.Entry<String, Integer> entry : column.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // 遍历所有单元格
        for (Table.Cell<String, String, Integer> cell : table.cellSet()) {
            System.out.println(cell.getRowKey() + ", " + cell.getColumnKey() + ": " + cell.getValue());
        }



    }




}
