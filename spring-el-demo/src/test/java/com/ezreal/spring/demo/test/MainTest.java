package com.ezreal.spring.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MainTest {

    @Test
    public void helloWorld() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World'");
        String value = (String) expression.getValue();
        System.out.println(value);
        Assertions.assertEquals("Hello World", value);
    }

    @Test
    void concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        Assertions.assertEquals("Hello World!", message);

    }

    @Test
    void getBytes() {
        ExpressionParser parser = new SpelExpressionParser();

        // invokes 'getBytes()'
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
    }

    @Test
    void getBytesLength() {
        ExpressionParser parser = new SpelExpressionParser();

        // invokes 'getBytes().length'
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp.getValue();
        System.out.println(length);
    }

    @Test
    void toUpperCase() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        System.out.println(message);
        Assertions.assertEquals("HELLO WORLD", message);

    }




}
