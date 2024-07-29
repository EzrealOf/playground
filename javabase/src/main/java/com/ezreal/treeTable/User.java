package com.ezreal.treeTable;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class User {


    private String rowName;

    LocalDateTime createTime;

    private boolean isDefault = false;



    private BigDecimal amount;

    private String columnName;

    private boolean isOther = false;
}
