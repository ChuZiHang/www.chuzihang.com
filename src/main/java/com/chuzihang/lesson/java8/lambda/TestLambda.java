package com.chuzihang.lesson.java8.lambda;

import java.util.*;

/**
 * Created by qw on 2018/5/8.
 */
public class TestLambda {

    /**
     * 原来的匿名内部类
     */
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    /**
     * Lambda表达式
     */
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    // 需求：获取年龄大于35的人

    public List<Employee> filterEmployee(List<Employee> employees) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getAge() > 35) {
                list.add(employee);
            }
        }
        return list;
    }

    // 需求：工资待遇5000的人
    public List<Employee> filterEmployee2(List<Employee> employees) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getSaraly() >= 5000) {
                list.add(employee);
            }
        }
        return list;
    }

    public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> mp) {
        List<Employee> list = new ArrayList<>();

        for (Employee employee : employees) {
            if (mp.test(employee)) {
                list.add(employee);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("里斯", 38, 8888.99),
                new Employee("王五", 50, 7777.77),
                new Employee("赵六", 16, 6666.66),
                new Employee("李琦", 20, 4444.44)
        );
        // 1.
        TestLambda testLambda = new TestLambda();
        List<Employee> list1 = testLambda.filterEmployee(employees);
        list1.forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("======================================================");
        // 1.策略方式
        List<Employee> list2 = testLambda.filterEmployee(employees, new FilterEmployeeByAge());
        list2.forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("======================================================");
        // 2.匿名内部类
        List<Employee> list3 = testLambda.filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSaraly() > 5000;
            }
        });
        list3.forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("======================================================");

        // 3. Lambda 表达式
        List<Employee> list4 = testLambda.filterEmployee(employees, employee -> employee.getSaraly() > 5000);

        list4.forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("======================================================");

        // 4. Stream API
        employees.stream()
                .filter(employee -> employee.getSaraly() > 5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("======================================================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
