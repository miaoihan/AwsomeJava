package Practice;

import java.util.Arrays;

/**
 * Author han on 16-1-12.
 * 1.两种遍历数组的方法
 * 2.copy数组
 */
public class ArrayTest {
    public int[] arr = {1, 2, 5, 8};

    public void putsArr1(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();

    }
    /** Java5 之后的新特性 **/
    public void putsArr2() {
        for (int a : arr){
            System.out.print(a);
        }
        System.out.println();
    }

    /** 数组copy **/
    public void copyArr(){
        int[] name = {1, 2, 3};
        int[] cpname = Arrays.copyOf(name,4);
        for (int c : cpname){
            System.out.print(c);
        }
    }

    public static void main(String[] args) {
        ArrayTest at = new ArrayTest();
        at.putsArr1();
        System.out.println("***************");
        at.putsArr2();
        at.copyArr();
    }
}
