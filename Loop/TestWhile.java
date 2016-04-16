package Loop;

/**
 * Created by han on 16-4-14.
 */
public class TestWhile {
    static boolean condition(){
        boolean result = Math.random() < 0.99;
        System.out.print(result+", ");
        return result;
    }

    public static void main(String[] args) {
        while(condition())
            System.out.println("in while");
        System.out.println("out while");
    }
}
