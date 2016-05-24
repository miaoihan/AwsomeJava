package Practice;

/**
 * @author han
 * @date 16-5-24.
 */
public class EqualsTest {
    public static void main(String[] args) {
        String name = null;
        /**   这样写就会抛出异常  */
//        if (name.equals("")) System.out.println("ok");
        /**   is ok!  */
        if ("".equals(name)) System.out.println("ok");
    }
}
