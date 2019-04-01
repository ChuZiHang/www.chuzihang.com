package com.chuzihang.lesson.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Recommend
 * @Description 课程中推荐的写法
 * @Author Q_先生
 * @Date 2018/11/2 9:43
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {
    String value() default "";
}
