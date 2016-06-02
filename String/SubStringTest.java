package String;

/**
 * @author han
 * @date 16-5-29.
 */
public class SubStringTest {
    public static void main(String[] args) {
        String a,b,c,d,e;
        a = "abc.123.xyz";
        b = a.substring(0,3);
        c = a.substring(3);
        int num = a.indexOf("c");
        d = a.substring(a.indexOf("x"));
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(num);
    }
}
