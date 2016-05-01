package algorithm;

/**
 * 普通的临时变量法交换
 * time: 16-5-1.
 * author: han
 */
public class Swap {
    public static void main(String[] args) {
        int x = 3;
        int y = 6;
        swap(x,y);
        System.out.println(x+" "+y);
        Value v = new Value(3,6);
        swap(v);
        System.out.println(v.x+" "+v.y);
    }

    /**
     * 无法交换
     * @param x param1
     * @param y
     */
    static void swap(int x, int y){
        int tmp = x;
        x = y;
        y = tmp;

    }

    /**
     * 封装起来交换
     * @param v
     */
    static void swap(Value v){
        int tmp = v.x;
        v.x = v.y;
        v.y = tmp;
    }
}

/**
 * 封装 x y
 */
class Value{
    int x;
    int y;

    public Value(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
