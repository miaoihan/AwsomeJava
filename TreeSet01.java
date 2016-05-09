import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet 自动排序元素
 * time: 16-5-9.
 * author: han
 */
public class TreeSet01 {
    public static void main(String[] args) {
        Set<Object> words = new TreeSet<>();
        Set<Number> words2 = new TreeSet<>();
        words.add("hello");
        words.add("apple");
        words.add("zhanghan");
        //不可以这样
//        words.add(123);
//        words.add(666);
        words2.add(66);
        words2.add(53);
        words2.add(17);
        System.out.println(words);
        System.out.println(words2);
    }

}
