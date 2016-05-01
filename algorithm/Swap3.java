package algorithm;

/**
 * 异或运算交换
 * time: 16-5-1.
 * author: han
 */
public class Swap3 {
    public static void main(String[] args) {
        Value v = new Value(300,6);
        swap(v);
        System.out.println(v.x+" "+v.y);
    }

    /**  根据 x ^ y ^ y == x    */
    static void swap(Value v){
        v.x = v.x ^ v.y;
        v.y = v.x ^ v.y;
        v.x = v.y ^ v.x;
    }
}
