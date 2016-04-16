package Game;

import java.util.Scanner;
/**
 * Created by han on 16-4-11.
 */

public class GuessNub {
    /**     猜数字的最大范围     */
    final static int RANGE = 100;
    /**     产生1--range范围的随机数     */
    static int num = (int) (Math.random()*RANGE+1);
    /**     猜的次数     */
    static int t = 0;
    /**     作弊码，输入-1开启 1；开启 0；关闭     */
    static int zb = 0;
    public static void main(String[] args) {
        //**** 作弊模式 open设置成1开启*****//
        if(zb == 1){
            System.out.println("*****作弊模式开启******");
            System.out.println("啦啦啦，数字就是:"+num);
            System.out.println("**********************");}
        //**** 开启作弊模式 *****//

        GuessNub gn = new GuessNub();
        System.out.println("请输入1到"+RANGE+"中的一个数:");
        gn.doIt();
    }
    public void doIt(){
        int a;
        do {
            if (t>=1)
                System.out.println("请再猜一个数:");
            a = getNum();

            ++t;
        } while (gudge(a) == 0);
    }

    public static int getNum(){
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        return num;
        return new Scanner(System.in).nextInt();
    }

    public static int gudge(int a){
        if (a==num) {
            if (t==1) {System.out.println("你竟然一次就猜对了，太牛b了！"); return 1;}
            if (t>1 && t<=4) {System.out.println("你猜对啦！，一共猜了"+t+"次，你好厉害哦！");return 1;}
            if (t>4 && t<=6) {System.out.println("你猜对啦！，一共猜了"+t+"次，还不错哦！");return 1;}
            if (t>6 && t<=8) {System.out.println("你猜对啦！，一共猜了"+t+"次，一般般啦...");return 1;}
            if(t>8) {System.out.println("你竟然猜了"+t+"次，你的智商真是堪忧啊");return 1;}
        }
        else if (a<num) {
            if (a==-1){
                zuobi();
                return 0;}
            System.out.println("你猜小啦！");
            return 0;}
        else {
            System.out.println("你猜大了！");
            return 0;
        }
        return 0;
    }

    public static void zuobi(){
//        if (zb==1){
            System.out.println("*****作弊模式开启******");
            System.out.println("啦啦啦，数字就是:"+num);
            System.out.println("**********************");
            t--;    //不计算次数
//        }
    }

}
