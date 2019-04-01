package com.chuzihang.lesson.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Q_先生
 * @Description 用来标记线程安全的类或者写法
 * @Date 9:46 2018/11/2
 * @Param
 * @return
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
