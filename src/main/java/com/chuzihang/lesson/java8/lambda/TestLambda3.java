package com.chuzihang.lesson.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by qw on 2018/5/10.
 */
public class TestLambda3 {

    public void test1(List<Employee> employees) {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public String strHandler(String str, Myfunction mf) {
        return mf.getValue(str);
    }

    public void test3(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("里斯", 38, 8888.99),
                new Employee("王五", 50, 7777.77),
                new Employee("赵六", 16, 6666.66),
                new Employee("李琦", 20, 4444.44)
        );
        TestLambda3 testLambda3 = new TestLambda3();
        testLambda3.test1(employees);

        String strHandler = testLambda3.strHandler("\t\t\t 哈哈哈哈哈  ", (str) -> str.trim());
        System.out.println(strHandler);


        String strHandler1 = testLambda3.strHandler("aaaaaseffg", (str) -> str.toUpperCase());
        System.out.println(strHandler1);

        String strHandler2 = testLambda3.strHandler("aaaaaseffg", (str) -> str.substring(2, 5));
        System.out.println(strHandler2);

        testLambda3.test3(100L,300L ,(x,y)-> x+y);
    }
}
