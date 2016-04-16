package Loop;

/**
 * Created by han on 16-4-14.
 */
public class TestRandom {
    public static void main(String[] args) {
        double a;
        do {
            a = Math.random();
            System.out.println(a);
        }

        while (a < 0.99);

    }
}
