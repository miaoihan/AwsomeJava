package String;

/**
 * @author han
 * @date 16-4-11.
 */
public class TestString {
    public static void main(String[] args) {
        String a,b;
        a = "hello";
//      b = "hello";                结果都是 true true, a b 都指向字符串常量池的同一个对象
        b = new String("hello");  //结果是  false true  a b指向不同的对象
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }
}
