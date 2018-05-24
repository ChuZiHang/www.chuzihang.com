package com.chuzihang.lesson.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by qw on 2018/5/24.
 */
public class TestStream2 {

    //1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
    public void test1(List<Transaction> transactions) {
        transactions.stream()
                .filter((x) -> x.getYear() == 2011)
                .sorted((x, y) -> Integer.compare(x.getValue(), y.getValue()))
                .forEach(System.out::println);
    }

    //2. 交易员都在哪些不同的城市工作过？
    public void test2(List<Transaction> transactions) {
        transactions.stream()
                .map((x) -> x.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
    }

    //3. 查找所有来自剑桥的交易员，并按姓名排序
    public void test3(List<Transaction> transactions) {
        transactions.stream()
                .filter((x) -> x.getTrader().getCity().equals("Cambridge"))
                .map((x -> x.getTrader()))
                .sorted((x, y) -> x.getName().compareTo(y.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母顺序排序
    public void test4(List<Transaction> transactions) {
        transactions.stream()
                .map((x) -> x.getTrader().getName())
                .distinct()
                .sorted()
                .forEach(System.out::print);

        System.out.println("-----------------------------------");

        String str = transactions.stream()
                .map((t) -> t.getTrader().getName())
                .sorted()
                .reduce("", String::concat);

        System.out.println(str);

        System.out.println("------------------------------------");

        transactions.stream()
                .map((t) -> t.getTrader().getName())
                .flatMap(TestStream2::filterCharacter)
                .sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
                .forEach(System.out::print);
        System.out.println("------------------------------------");
    }

    public static Stream<String> filterCharacter(String str) {
        List<String> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch.toString());
        }

        return list.stream();
    }

    //5. 有没有交易员是在米兰工作的？
    public void test5(List<Transaction> transactions) {
        boolean milan = transactions.stream()
                .anyMatch((x) -> x.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    //6. 打印生活在剑桥的交易员的所有交易额
    public void test6(List<Transaction> transactions) {
        Optional<Integer> cambridge = transactions.stream()
                .filter((e) -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum);
        System.out.println(cambridge.get());
    }

    //7. 所有交易中，最高的交易额是多少
    public void test7(List<Transaction> transactions) {
        Optional<Integer> cambridge = transactions.stream()
                .map((x) -> x.getValue())
                .max(Integer::compare);
        System.out.println(cambridge.get());
    }

    //8. 找到交易额最小的交易
    public void test8(List<Transaction> transactions) {
        Optional<Transaction> min = transactions.stream()
                .min((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        System.out.println(min.get());
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        TestStream2 testStream2 = new TestStream2();
        testStream2.test1(transactions);
        testStream2.test2(transactions);
        testStream2.test3(transactions);
        testStream2.test4(transactions);
        testStream2.test5(transactions);
        testStream2.test6(transactions);
        testStream2.test7(transactions);
        testStream2.test8(transactions);
    }
}
