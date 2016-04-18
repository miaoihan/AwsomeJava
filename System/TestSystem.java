package System;
//import static net.mindview.util.Print.*;

/**
 * Created by han on 16-4-17.
 */
public class TestSystem {

    public static void main(String[] args) {
//        System.out.println("please input: ");
//        String ss = getInput();
//        System.out.println("ss: "+ss);
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java..class.path"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("java."));
    }

    public static String getInput(){
        StringBuffer sb = new StringBuffer();
        try {
            char c = (char) System.in.read();

            while (c != '\r'){
                sb.append(c);
                c = (char) System.in.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
