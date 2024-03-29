package com.ezreal.spring.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class TypeTest {

    @Test
    void typeConversion(){
        Simple simple = new Simple();
        simple.booleanList.add(true);

        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        ExpressionParser parser = new SpelExpressionParser();
        // "false" is passed in here as a String. SpEL and the conversion service
        // will recognize that it needs to be a Boolean and convert it accordingly.
        parser.parseExpression("booleanList[0]").setValue(context, simple, "false");
        // b is false
        Boolean b = simple.booleanList.get(0);
        Assertions.assertEquals(false, b);

    }
    @Test
    void getValue(){

        SpelParserConfiguration config = new SpelParserConfiguration(true,true);
        SpelExpressionParser parser = new SpelExpressionParser(config);
        Expression expression = parser.parseExpression("list[3]");
        Demo demo = new Demo();
        Object value = expression.getValue(demo);

        demo.list.add(1, "kitty");
        Assertions.assertEquals("", value);
        // demo.list will now be a real collection of 4 entries
        // Each entry is a new empty String
    }

    @Test
    void spelConfig(){
        SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass().getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(config);

        Expression expr = parser.parseExpression("payload");


    }
    class Simple {
        public List<Boolean> booleanList = new ArrayList<Boolean>();
    }
    class Demo {
        public List<String> list;
    }



}
