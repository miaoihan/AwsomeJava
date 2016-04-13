package String;

/**
 * Created by han on 16-4-11.
 */
public class TestToString {
    public static void main(String[] args) {
        MyData md1 = new MyData(11,4,2016);
        MyData md2 = new MyData2(11,4,2016);
        System.out.println(md1);    //默认调用toString方法
        System.out.println(md2);
    }
}

class MyData{
    int day, month, year;

    public MyData(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

class MyData2 extends MyData{

    public MyData2(int day, int month, int year) {
        super(day, month, year);
    }

    @Override
    public String toString() {
        return year+"-"+month+"-"+day;
    }
}