package com.ezreal.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2022/3/21.
 *
 * @author Ezreal
 */
@Aspect
@Component
@Order(200)
public class AopLockAspect {

    ExpressionParser parser = new SpelExpressionParser();

    Map<Method, Expression> idempotentExpressionMap = new ConcurrentHashMap<>();

    @Around(value = "@annotation(com.ezreal.aop.AopLock)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        AopLock aopLock = method.getDeclaredAnnotation(AopLock.class);
        String expressions = aopLock.expressions();
        String returnExpressions = aopLock.returnExpressions();
        Class<?> aClass = aopLock.targetType();

        Object keyOf = keyOf(method, args, expressions, aClass);
        changeKey(method, args, expressions);
        Object proceed = joinPoint.proceed();
        changeKey(method, proceed, returnExpressions);
        return proceed;
    }


    private void changeKey(Method method, Object args, String expressions) {
        if (StringUtils.isNotBlank(expressions)) {
            Expression expression = expressionOf(method, expressions);
            if (Objects.nonNull(expression)) {
                StandardEvaluationContext ctx = new StandardEvaluationContext();
                Parameter[] parameters = method.getParameters();
                if (Objects.nonNull(parameters)) {
                    for (int i = 0; i < parameters.length; i++) {
                        ctx.setVariable(parameters[i].getName(), args);
                    }
                }
                expression.setValue(ctx, "key234");
            }
        }
    }


    private void changeKey(Method method, Object[] args, String expressions) {
        if (StringUtils.isNotBlank(expressions)) {
            Expression expression = expressionOf(method, expressions);
            if (Objects.nonNull(expression)) {
                StandardEvaluationContext ctx = new StandardEvaluationContext();
                Parameter[] parameters = method.getParameters();
                if (Objects.nonNull(parameters)) {
                    for (int i = 0; i < parameters.length; i++) {
                        ctx.setVariable(parameters[i].getName(), args[i]);
                    }
                }
                expression.setValue(ctx, "key");
            }
        }
    }


    private <T>  T keyOf(Method method, Object[] args, String expressions, Class<?> targetType) {
        T key = null;
        if (StringUtils.isNotBlank(expressions)) {
            Expression expression = expressionOf(method, expressions);
            if (Objects.nonNull(expression)) {
                StandardEvaluationContext ctx = new StandardEvaluationContext();
                Parameter[] parameters = method.getParameters();
                if (Objects.nonNull(parameters)) {
                    for (int i = 0; i < parameters.length; i++) {
                        ctx.setVariable(parameters[i].getName(), args[i]);
                    }
                }
                key = (T) expression.getValue(ctx, targetType);
            }
        }

        return key;
    }

    private String keyOf(Method method, Object[] args, String expressions) {
        String key = null;
        if (StringUtils.isNotBlank(expressions)) {
            Expression expression = expressionOf(method, expressions);
            if (Objects.nonNull(expression)) {
                StandardEvaluationContext ctx = new StandardEvaluationContext();
                Parameter[] parameters = method.getParameters();
                if (Objects.nonNull(parameters)) {
                    for (int i = 0; i < parameters.length; i++) {
                        ctx.setVariable(parameters[i].getName(), args[i]);
                    }
                }
                key = expression.getValue(ctx, String.class);
            }
        }

        return key;
    }

    private Expression expressionOf(Method method, String expressions) {
        Expression expression = idempotentExpressionMap.get(method);
        if (Objects.isNull(expression)) {
            synchronized (this) {
                expression = idempotentExpressionMap.get(method);
                if (Objects.isNull(expression)) {
                    expression = parser.parseExpression(expressions);
                    idempotentExpressionMap.put(method, expression);
                }
            }
        }
        return expression;
    }
}
