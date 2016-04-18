package Array;

/**
 * Created by han on 16-4-16.
 */
public class TestArray {

    public static void main(String[] args) {
        /**  声明数组不会给数组分配空间，编译器只是创建了一个对象引用   */
        int [] a;
        int b[];
        /**  new的时候必须指定数组大小   */
        String [] s = new String[10];
//        s[0] = "hello";
        s = new String[]{"zhangsan", "lisi","wangermazi"};
        /**  非法   */
//        int num = average({1,8,25,13});
        /**  需要实例化数组   */
        float[] num = {1,8,25,13};
        float avg = average(num);
        /**  OR  */
        float avg2 = average(new float[] {1,8,25,13});
        System.out.println(avg);
        System.out.println(avg2);
//        float aaa = (float)47/4;
//        System.out.println(aaa);
    }

    static float average(float[] num){
        float sum = 0;
        /**  遍历数组的几种方法   */
//        for (int i = 0; i < num.length; i++) {
//            sum += num[i];
//        }
//        for (float a : num)
//            sum += a;

        return sum/num.length;
    }

}
