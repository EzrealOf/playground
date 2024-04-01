package com.ezreal.entity;


import java.io.Serializable;

public class AopTestVO implements Serializable {

    private String name;

    private String idNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}

