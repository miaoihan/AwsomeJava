package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * time: 16-5-9.
 * author: han
 */
public class HashSetTest2 {

    public static void main(String[] args) {
        Set<String> name = new HashSet<>();
        name.add("miao");
        name.add("zzzz");
        name.add("miaoihan");
        name.add("mia231an");
        name.add("han");
        name.add("miao3232an");
        name.add("migerhan");
        //按照某种顺序随机输出
        System.out.println(name);
//        for (String s : name) {
//            System.out.println(s);
//        }
        name.forEach(System.out::println);
    }
}
