package org.example.flashSales.annotation;

import java.lang.annotation.*;

/**
 * @description: 请求限流注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface AccessLimit {

    /**
     * 指定时间
     * @return
     */
    int seconds() default 60;

    /**
     * seconds时间内最多允许访问maxValue次数
     * @return
     */
    int maxValue();

    /**
     * 该请求是否需要登录
     * @return
     */
    boolean needLogin() default true;
}