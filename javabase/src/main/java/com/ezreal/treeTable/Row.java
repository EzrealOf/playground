package com.ezreal.treeTable;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class Row implements Serializable {

    private String rowName;

    private boolean isOther;

    private BigDecimal amount;

}
