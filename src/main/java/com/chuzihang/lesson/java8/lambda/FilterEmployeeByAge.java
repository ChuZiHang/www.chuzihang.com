package com.chuzihang.lesson.java8.lambda;

/**
 * Created by qw on 2018/5/8.
 */
public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee o) {
        return o.getAge() > 35;
    }
}
