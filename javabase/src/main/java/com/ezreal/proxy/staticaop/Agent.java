package com.ezreal.proxy.staticaop;

import lombok.Data;

/**
 * @author ezreal
 */
@Data
public class Agent implements Person{
    Actor actor;
    String before;
    String after;

    public Agent(Actor actor, String before, String after){
        this.actor = actor;
        this.before = before;
        this.after = after;
    }

    @Override
    public void speak() {
        System.out.println(before);
        actor.speak();
        System.out.println(after);

    }
}
