package com.ezreal.treeTable;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Builder
public class Column implements Serializable {

    private String columnName;
    
    private boolean isDefault = false;

    private LocalDateTime createTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column column = (Column) o;
        return isDefault == column.isDefault && Objects.equals(columnName, column.columnName) && Objects.equals(createTime, column.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnName, isDefault, createTime);
    }
}
