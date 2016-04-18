package Array;

import java.util.Arrays;

/**
 * Created by han on 16-4-17.
 */
public class CopyArray {
    public static void main(String[] args) {
        int[] num = {1,2,8,};
        /**  扩展数组，只能通过申请新数组然后填充之   */
        int[] tmp = new int[4];
        for (int i = 0; i < num.length; i++) {
            tmp[i] = num[i];
        }
        num = tmp;
        /**  util.Array 的copyOf方法   */
        int[] num2 = {2,5,3};
//        int[]tmp2 = Arrays.copyOf(num,4);
        num2 = Arrays.copyOf(num2,4);

        for (int a : num) {
            System.out.print(a);
        }
        System.out.println("");
        for (int i : num2) {
            System.out.print(i);

        }

    }

}