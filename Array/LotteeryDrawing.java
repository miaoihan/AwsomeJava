package Array;

import java.util.Random;
import java.util.Scanner;

/**
 * time: 16-5-6.
 * author: han
 */
public class LotteeryDrawing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("总共多少个数字：");
        int b = sc.nextInt();
        System.out.println("抽几个数字：");
        int a = sc.nextInt();

        //填充数组
        int number[] = new int[b];
        for (int i = 0; i < number.length; i++) {
            number[i] = i + 1;
        }

        //抽奖数组
        int result[] = new int[a];
        for (int i = 0; i < result.length; i++) {
            int n = (int) (Math.random() * a);
            result[i] = number[n];
            //把数组最后一个数放到n上
            number[n] = number[b-1];
            b--;
        }
        System.out.println("*****抽奖结果*****");
        for (int rs: result) {
            System.out.println(rs);
        }

    }

}
