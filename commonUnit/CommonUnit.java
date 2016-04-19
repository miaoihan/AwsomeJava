package commonUnit;

/**
 * 我自己写的公共方法
 * Author han on 16-1-13.
 */
public class CommonUnit {

    public static void put(Object... msgs){
        for (Object msg : msgs) {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        put("hello!");
        put(222);
    }
}
