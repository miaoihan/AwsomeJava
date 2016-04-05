package practice;
import commonUnit.CommonUnit;

/**
 * Author han on 16-1-12.
 */
public class Box {
    public      int   length;
    private     int   height;
    protected   int   width;

    public Box(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void putItem(){
        System.out.println("盒子的长："+this.length);
        System.out.println("盒子的宽："+this.width);
        System.out.println("盒子的高："+this.height);
//        CommonUnit.puts();
    }

    public static void main(String[] args) {
        Box box = new Box(2,2,3);
        box.putItem();
    }
}
