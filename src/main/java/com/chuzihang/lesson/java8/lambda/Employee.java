package com.chuzihang.lesson.java8.lambda;

/**
 * Created by qw on 2018/5/8.
 */
public class Employee {

    private int id;
    private String name;
    private int age;
    private double saraly;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee( String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.saraly = salary;
    }


    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.saraly = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSaraly() {
        return saraly;
    }

    public void setSaraly(double saraly) {
        this.saraly = saraly;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", saraly=" + saraly +
                '}';
    }

    public String show() {
        return "测试方法引用！";
    }
}
