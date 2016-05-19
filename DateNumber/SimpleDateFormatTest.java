package DateNumber;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Author han on 16-1-13.
 */
public class SimpleDateFormatTest {
    String pattern = "yyyy-MM-dd HH:mm:ss"; //注意格式，大小写！
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    public static void main(String[] args) {
        String pattern = "MM/dd/yyyy"; //注意格式，大小写！
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse("08/11/1993");
            System.out.println(sdf.format(date));
            System.out.println(date);
            System.out.println(new SimpleDateFormat().format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date()));


        SimpleDateFormatTest st = new SimpleDateFormatTest();
        st.StringToDate("08/11/1993");

    }
    Date StringToDate(String sd){
        Date date = null;
        try {
            date = sdf.parse(sd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        return date;
    }
}
