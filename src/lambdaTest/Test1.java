package lambdaTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Derscription TODO
 * @auther David
 * @date 2018-08-31 9:57
 * @Version 1.o
 */
public class Test1 {
    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    private static void test3() {
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

         // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        for (String a : players) {
            System.out.println(a);
        }

        // 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);

        // 1.3 也可以采用如下形式:
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
    }

    private static void test2() {
        //1.1使用匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        }).start();

        //1.2使用lambda
        new Thread(() -> System.out.println("hello world!")).start();

        //2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };

        //2.2使用lambda
        Runnable race2 = () -> System.out.println("hello world");
        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }

    private static void test1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray", "Tomas Berdych",
                "Juan Martin Del Potro"};
        //传统方式
        List<String> players = Arrays.asList(atp);
        for (String p : players) {
            System.out.println(p + ";");
        }

        //使用lambda表达式
        players.forEach((p) -> System.out.println(p + ";"));

        //在Java8中使用双冒号操作符
        players.forEach(System.out::println);
    }
}
