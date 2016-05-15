/**
 * 各种花式遍历集合
 * @auth：han
 *
 *方法二遍历：
 *内部调用第一种
 *
 *方法三遍历：
 *内部不锁定, 效率最高, 但是当写多线程时要考虑并发操作的问题
 *
 *方法四、五遍历：
 *执行过程中会进行数据锁定, 性能稍差, 同时,如果你想在循环过程中去掉某个元素,只能调用it.remove方法。
 */

package collection;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        String s1 = "hello";
        int a = 6;
        double b = 5.785;
//        boolean bo = true;
        list.add(s1);
        list.add(a);
        list.add(b);
        list.add(true);
        list.add(6);            //可添加重复项
        list.set(2,"ok!");
        list.add(2,"insert");   //A

//      1.  list.forEach(System.out::println);

//      2.  for (Object o : list)
//            System.out.println(o);

        /**我还是最喜欢这个**/
       for (int i = 0; i < list.size() ; i++) {
            System.out.println(i+":"+list.get(i));
        }

//      4.  Iterator it = list.iterator();
//        while (it.hasNext()){
//            Object st = it.next();
//            System.out.println(st);
//        }

//      5.  for (Iterator it = list.iterator(); it.hasNext();){
//                Object st = it.next();
//                System.out.println(st);
//        }

    }

}
