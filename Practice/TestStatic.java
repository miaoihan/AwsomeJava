package Practice;

import static Practice.TestStatic.a;

/**
 * Created by han on 16-4-15.
 */
public class TestStatic {
    /**
     * static修饰变量 JVM只为其分配一次变量
     * 可用类名直接访问
     * 也可以用对象访问（不推荐）
     */
     public static int a;
}

class Geta{
    String st = "hello";
    public static void main(String[] args) {
        TestStatic t1 = new TestStatic();
        TestStatic t2 = new TestStatic();
        /**  import static Practice.TestStatic.a   */
        System.out.println(a++);
        /**  类名直接访问   */
        System.out.println(TestStatic.a);
        /**  对象访问   */
        System.out.println(t1.a++);
        System.out.println(t2.a++);
        /**  应该输出: 0 1 1 2 **/
    }

    /**
     * 修饰方法
     *
     */
    static void do1(){
        /**  static方法无法访问非static成员变量   */
//        System.out.println(st);

        System.out.println(a);
    }
}
