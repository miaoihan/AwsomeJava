package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * time: 16-5-6.
 * author: han
 */
public class SortTest {
    public static void main(String[] args) {
        int arrs[] = new int[10];
        System.out.println("input 10 array members:");
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = new Scanner(System.in).nextInt();
        }
        Arrays.sort(arrs);
        System.out.println("排序之后");
        for (int arr : arrs) {
            System.out.println(arr);
        }

    }
}
