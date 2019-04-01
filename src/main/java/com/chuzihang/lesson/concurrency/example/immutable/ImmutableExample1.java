package com.chuzihang.lesson.concurrency.example.immutable;

import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @ClassName ImmutableExample1
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 15:39
 **/
@Slf4j
@ThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(4, 5);
        map.put(6, 7);
        map = Collections.unmodifiableMap(map); //JDK 不可变对象
    }

    public static void main(String[] args) {
        map.put(4, 5);
    }
}
