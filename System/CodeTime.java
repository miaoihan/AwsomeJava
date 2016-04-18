package System;

/**
 * Created by han on 16-4-17.
 */
public class CodeTime {
    public static void main(String[] args) {
        /** 代码开始时间 */
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1 ; j++) {

            }
        }
//        long nn = 0;
//        for (int i = 0; i < 50000000; i++) {
//            nn = jiecheng(31);
//        }
//
//        System.out.println(nn);
        long end = System.nanoTime();
//        long end = System.currentTimeMillis();
        /**  代码结束时间   */
        System.out.println("time: " +(end-start));
    }

    static int jiecheng(int a){
        for (int i = 0; i < 8886888; i++) {
            for (int j = 0; j < 10000000; j++) {

            }
        }
        if (a<=1) return 1;
        else return a*jiecheng(a-1);
    }


}
