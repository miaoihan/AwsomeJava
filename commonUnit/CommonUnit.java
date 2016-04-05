package commonUnit;

/**
 * Author han on 16-1-13.
 */
public class CommonUnit {

    public static void puts(Object... msgs){
        for (Object msg : msgs) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        puts("hello!");
        puts(222);
    }
}
