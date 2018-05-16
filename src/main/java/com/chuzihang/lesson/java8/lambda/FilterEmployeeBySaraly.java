package com.chuzihang.lesson.java8.lambda;

/**
 * Created by qw on 2018/5/8.
 */
public class FilterEmployeeBySaraly implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSaraly() > 5000;
    }
}
