package DateNumber;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Author han on 16-1-13.
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) {
        String pattern = "MM/dd/yyyy"; //注意格式，大小写！
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date date = sdf.parse("11/08/1993");
            System.out.println(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sdf.format(new Date()));
    }
}
