package com.ezreal.spring.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariablesTest {

    @Test
    void variable(){
        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2,3,5,7,11,13,17));

        // create parser and set variable 'primes' as the array of integers
        ExpressionParser parser = new SpelExpressionParser();
//        SimpleEvaluationContext simpleEvaluationContext = new SimpleEvaluationContext().;
//        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataAccess();
//        context.setVariable("primes", primes);

        // all prime numbers > 10 from the list (using selection ?{...})
        // evaluates to [11, 13, 17]
//        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression(
//                "#primes.?[#this>10]").getValue(context);

    }
}
