package com.chuzihang.lesson.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName NotRecommend
 * @Description 课程中用来标记【不推荐】的类或者写法
 * @Author Q_先生
 * @Date 2018/11/2 9:38
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotRecommend {
    String value() default "";
}
