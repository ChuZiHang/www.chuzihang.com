package com.chuzihang.lesson.concurrency.example.immutable;

import com.chuzihang.lesson.concurrency.annoations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

/**
 * @ClassName ImmutableExample2
 * @Description TODO
 * @Author Q_先生
 * @Date 2018/11/2 15:45
 **/

@ThreadSafe
public class ImmutableExample2 {

    private static final ImmutableList list = ImmutableList.of(1, 2, 3);//Guava

    private static final ImmutableSet set = ImmutableSet.copyOf(list);

    private static final ImmutableMap<Integer, Integer> map2 = ImmutableMap.of(1, 2, 3, 4, 5, 6);

    public static void main(String[] args) {
        list.add(1);
        set.add(1);
    }
}
