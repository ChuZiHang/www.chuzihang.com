package com.chuzihang.lesson.java8.stream;

import com.chuzihang.lesson.java8.lambda.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by qw on 2018/5/17.
 * <p>
 * 1. 创建 Stream
 * <p>
 * 2. 中间操作
 * <p>
 * 3. 终止操作(终端操作)
 */
public class TestStream1 {

    /**
     * 1. 创建 Stream
     */
    public void test1() {
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }

    //2. 中间操作
    /*
      筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
    //内部迭代：迭代操作 Stream API 内部完成
    public void test2(List<Employee> emps) {
        //所有的中间操作不会做任何的处理
        Stream<Employee> stream = emps.stream().filter((s) -> {
            System.out.println("测试中间操作");
            return s.getAge() <= 35;
        });
        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    public void test3(List<Employee> emps) {
        Iterator<Employee> it = emps.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void test4(List<Employee> emps) {
        emps.stream()
                .filter((e) -> {
                    System.out.println("短路！"); // &&  ||
                    return e.getSaraly() >= 5000;
                }).limit(3)
                .forEach(System.out::println);
    }

    public void test5(List<Employee> emps) {
        emps.parallelStream()
                .filter((e) -> e.getSaraly() >= 5000)
                .skip(2)
                .forEach(System.out::println);
    }

    public void test6(List<Employee> emps) {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    public void test7(List<Employee> emps) {
        Stream<String> str = emps.stream()
                .map((e) -> e.getName());

        System.out.println("-------------------------------------------");

        List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

        Stream<String> stream = strList.stream()
                .map(String::toUpperCase);

        stream.forEach(System.out::println);

        Stream<Stream<Character>> stream2 = strList.stream()
                .map(TestStream1::filterCharacter);

        stream2.forEach((sm) -> {
            sm.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        Stream<Character> stream3 = strList.stream()
                .flatMap(TestStream1::filterCharacter);

        stream3.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }

    public void test8(List<Employee> emps) {
        emps.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------------");

        emps.stream()
                .sorted((x, y) -> {
                    if (x.getAge() == y.getAge()) {
                        return x.getName().compareTo(y.getName());
                    } else {
                        return Integer.compare(x.getAge(), y.getAge());
                    }
                }).forEach(System.out::println);
    }

    public void test9(List<Employee> emps) {
        Optional<Employee> op = emps.stream()
                .sorted((e1, e2) -> Double.compare(e1.getSaraly(), e2.getSaraly()))
                .findFirst();

        System.out.println(op.get());

        System.out.println("--------------------------------");

    }

    //3. 终止操作
    /*
		归约
		reduce(T identity, BinaryOperator) / reduce(BinaryOperator) ——可以将流中元素反复结合起来，得到一个值。
	 */
    public void test10(List<Employee> emps) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);

        System.out.println(sum);

        System.out.println("----------------------------------------");

        Optional<Double> op = emps.stream()
                .map(Employee::getSaraly)
                .reduce(Double::sum);

        System.out.println(op.get());
    }

    //需求：搜索名字中 “六” 出现的次数
    public void test11(List<Employee> emps){
        Optional<Integer> sum = emps.stream()
                .map(Employee::getName)
                .flatMap(TestStream1::filterCharacter)
                .map((ch) -> {
                    if(ch.equals('六'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum);

        System.out.println(sum.get());
    }

    //collect——将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法
    public void test12(List<Employee> emps){
        List<String> list = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("----------------------------------");

        Set<String> set = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        set.forEach(System.out::println);

        System.out.println("----------------------------------");

        HashSet<String> hs = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        hs.forEach(System.out::println);
    }

    public void test13(List<Employee> emps){
        Optional<Double> max = emps.stream()
                .map(Employee::getSaraly)
                .collect(Collectors.maxBy(Double::compare));

        System.out.println(max.get());

        Optional<Employee> op = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSaraly(), e2.getSaraly())));

        System.out.println(op.get());

        Double sum = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSaraly));

        System.out.println(sum);

        Double avg = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSaraly));

        System.out.println(avg);

        Long count = emps.stream()
                .collect(Collectors.counting());

        System.out.println(count);

        System.out.println("--------------------------------------------");

        DoubleSummaryStatistics dss = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSaraly));

        System.out.println(dss.getMax());
    }

    //分组
    public void test14(List<Employee> emps){
        Map<Integer, List<Employee>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        System.out.println(map);
    }

    // 多级分组
    public void test15(List<Employee> emps){
        Map<Integer, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy((e) -> {
                    if(e.getAge() >= 60)
                        return "老年";
                    else if(e.getAge() >= 35)
                        return "中年";
                    else
                        return "成年";
                })));

        System.out.println(map);
    }

    //分区
    public void test16(List<Employee> emps){
        Map<Boolean, List<Employee>> map = emps.stream()
                .collect(Collectors.partitioningBy((e) -> e.getSaraly() >= 5000));

        System.out.println(map);
    }

    public void test17(List<Employee> emps){
        String str = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("," , "--6--", "--8--"));

        System.out.println(str);
    }

    public void test18(List<Employee> emps){
        Optional<Double> sum = emps.stream()
                .map(Employee::getSaraly)
                .collect(Collectors.reducing(Double::sum));

        System.out.println(sum.get());
    }

    public static void main(String[] args) {
        TestStream1 testStream = new TestStream1();
//        testStream.test1();

        List<Employee> emps = Arrays.asList(
                new Employee(102, "李四", 59, 6666.66),
                new Employee(101, "张三", 18, 9999.99),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );
//        testStream.test2(emps);
//        testStream.test17(emps);
//        testStream.test18(emps);
        testStream.test16(emps);

    }
}
