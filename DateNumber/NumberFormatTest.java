package DateNumber;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Author han on 16-1-13.
 * 格式化数字，千位分割
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        System.out.println(nf.getClass().getName());
        System.out.println(nf.format(520520131));
    }
}
