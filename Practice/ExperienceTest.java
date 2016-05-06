package Practice;

/**
 * 能不用异常处理就别用
 * 拖慢很多速度
 * time: 16-5-6.
 * author: han
 */
public class ExperienceTest {
    public static void main(String[] args) {
        int s = 0;
        long start = System.nanoTime();
        int t = 1000000;
        //try catch 执行
        for (int i = 0; i < t; i++) {
            try {
                s = 6/s;
            } catch (Exception e) {

            }
        }
        long end = System.nanoTime();
//        long end = System.currentTimeMillis();
        /**  代码结束时间   */
        System.out.println("time: " +(end-start));

        //先判断 执行
        long start2 = System.nanoTime();
        for (int i = 0; i < t ; i++) {
            if (s != 0) {
                s = 6/s;
            }
        }
        long end2 = System.nanoTime();
        System.out.println("time: " +(end2-start2));
        //最后结果try catch 541ms
        //   判断           5ms
        //差了两个数量级
    }
}
