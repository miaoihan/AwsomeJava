package DateNumber;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Demo01 {

    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub

        Date d1 = new Date(System.currentTimeMillis());

        Calendar c1 = Calendar.getInstance();

//		格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("格式化前d1=" + d1.toString());
        System.out.println("格式化后d1=" + sdf.format(d1));

//		String和Date转换
        String date = "2015-06-01";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = sdf1.parse(date);
        System.out.println("String转换为Date,d2=" + d2.toString());


//		由Date类型转换为String类型
        String s1 = sdf1.format(d2);
        System.out.println("Date转换为String,s1 =" + s1);







    }

}