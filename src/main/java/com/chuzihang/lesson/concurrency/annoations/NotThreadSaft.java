package com.chuzihang.lesson.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName NotThreadSaft
 * @Description 标记线程不是安全的
 * @Author Q_先生
 * @Date 2018/11/2 9:41
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSaft {
    String value() default "";
}
