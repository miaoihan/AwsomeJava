package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较ArrayList 和 LinkedList的性能
 * time: 16-5-6.
 * author: han
 */
public class CompareArrAndLink {
    /** 代码写的比较乱，并没有分成各个方法，为了减小测试误差
     *  Java 要是能实现time（{code}）就好了 */
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        List<Integer> num2 = new LinkedList<>();
        /**  添加1M个数据用时差不多，8ms左右   */
        long start3 = System.nanoTime();
//        for (int i = 0; i < 100000; i++) {
//            num.add(i);
//        }
//        long end3 = System.nanoTime();
//        System.out.println("ArrayList costs time:" + (end3 - start3));

        long start4 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            num2.add(i);
        }
        long end4 = System.nanoTime();
        System.out.println("LinkList costs time:" + (end4 - start4));
        /***************  比较 add  **************/
        /**  时间是三次测试取平均值*
         *   要注意！ 先后顺序、电源插电，等都影响执行效率
         *   后执行时cpu已经启动，耗时比较少
         *   在测试的时候要保持
         *   1.注释另外一段代码（也可以在最开始写一段“热身”代码）
         *   2.保持电源接通*/
//        //array
//        long start = System.nanoTime();
//////        num.add(8);          // 18 us
////        num.add(1000000,8);// 56 us
//////        num.add(500000,8); // 270 us
////        /** 这里开始性能并没有下降（测试数据1M的时候）*/
//////        num.add(100000,8); // 586 us
//////        num.add(10000,8);  // 683 us
//////        num.add(1000,8);   // 515 us
//        /** 当我把i加到1亿的时候，这段代码让我电脑烧起来了
//         *  觉得好玩的小伙伴 可以试试 */
//        num.add(0,8);      // i=1M：579 us i=10M: 5812us i=100M: give up...
//        long end = System.nanoTime();
//        System.out.println("ArrayList costs time:" + (end - start));

        //link
        long start2 = System.nanoTime();
        num2.add(8);//   24 us
//        num2.add(1000000,8);//   32 us
//        num2.add(800000,8);//   2810 us
//        num2.add(500000,8);//   5200 us
//        num2.add(300000,8);//   4702 us
//        num2.add(100000,8);//   1646 us
//        num2.add(50000,8);//   1100 us
//        num2.add(5000,8);//   135 us
//        num2.add(1000,8);//   61 us
        num2.add(0,8);//   43 us(1M)
        long end2 = System.nanoTime();
        /**  证明是双向链表
         *   在头节点和首节点插入的时候时间最少
         *   中间节点时间最长*/
        System.out.println("LinkList costs time:" + (end2 - start2));

        /******************* 比较get *******************/
        /** 这种效率是极低的，LinkList没有任何缓存位置的操作 */
        long start5 = System.nanoTime();
        for (int i = 0; i < num2.size(); i++) {
            int n = num2.get(i);
        }
        long end5 = System.nanoTime();
        System.out.println("Get LinkList Elems costs time:" + (end5 - start5));//花了4s...
    }
}
