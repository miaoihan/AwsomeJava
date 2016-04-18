package System;

/**
 * Created by han on 16-4-17.
 */
public class TestSystem {

    public static void main(String[] args) {
//        System.out.println("please input: ");
//        String ss = getInput();
//        System.out.println("ss: "+ss);
        System.getProperty("java.version");
        System.getProperty("java..class.path");
        System.getProperty("user.dir");
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
