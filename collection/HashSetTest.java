package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * 使用HashSet集合打印所有不同的单词
 * time: 16-5-9.
 * author: han
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        Scanner sc = new Scanner(System.in);
        /** 输入0结束 */
        while (!sc.hasNext("0")){//书中应该是写错了，无法终止
            String word = sc.next();
            long callTime = System.nanoTime();
            /**set无法加入重复的单词*/
            words.add(word);
            callTime = System.nanoTime() - callTime;
            totalTime += callTime;
        }

        Iterator<String> iter = words.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + " 个不同的单词. " + totalTime + " ns.");
    }
}
