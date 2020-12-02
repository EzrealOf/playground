package com.ezreal.test;

import lombok.Data;

/**
 * @author ezreal
 */
@Data
public class Dog {

    private String la;

    public void say(){
        System.out.println("汪汪汪汪汪汪");
    }

    public void fei(String la){
        System.out.println("汪汪汪"+ la);
    }
}
