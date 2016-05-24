package Practice;

/**
 * @author han
 * @date 16-5-21.
 */
public class shenqi {
    public static void main(String[] args) {
        String a = " aaa bbbb ccc  ";
        a.replace(" ", "" );//是不行的
        String b = a.replace(" ","");
        System.out.println(b);
        String str = " hell o ";
        String str2 = str.replaceAll(" ", "");
        System.out.println(str2);
    }
}
