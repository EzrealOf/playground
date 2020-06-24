package com.ezreal.proxy.staticaop;
import lombok.Data;
/**
 * @author ezreal
 */
@Data
public class Actor implements Person {
    String message;


    public Actor(String message){
        this.message = message;
    }
    @Override
    public void speak() {
        System.out.println(message);
    }
}
