package lambda;

import java.util.Arrays;
import java.util.List;

/**
 * time: 16-5-4.
 * author: han
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        System.out.println("以前的循环方式");
        for (String player : players) {
            System.out.print(player + "; ");
        }

        System.out.println("使用 lambda 表达式以及函数操作(functional operation)");
        players.forEach((player) -> System.out.print(player + "; "));

        System.out.println("在 Java 8 中使用双冒号操作符(double colon operator)");
        players.forEach(System.out::println);
        Runnable aa = () -> System.out.println("aa");
        aa.run();
    }
}
