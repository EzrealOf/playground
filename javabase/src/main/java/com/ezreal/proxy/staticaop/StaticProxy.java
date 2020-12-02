package com.ezreal.proxy.staticaop;

/**
 * @author ezreal
 */
public class StaticProxy {
    public static void main(String[] args) {
        Actor actor = new Actor("I am ok");
        Agent agent = new Agent(actor, "hello", "me too");
        actor.speak();
        agent.speak();
    }
}
