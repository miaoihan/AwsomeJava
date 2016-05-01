package algorithm;

/**
 * 求和再减的交换
 * time: 16-5-1.
 * author: han
 */
public class Swap2 {
    public static void main(String[] args) {
        Value v = new Value(3,6);
        swap(v);
        System.out.println(v.x+" "+v.y);
    }

    static void swap(Value v){
//        v.x = v.x + v.y;
        int sum = v.x + v.y;
        v.y = sum - v.y;
        v.x = sum - v.y;

    }
}


