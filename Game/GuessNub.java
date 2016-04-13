package Game;

import java.util.Scanner;


/**
 * Created by han on 16-4-11.
 */
public class GuessNub {
    static int num = (int) (Math.random()*100);
    static int t = 1;
    public static void main(String[] args) {
        String open = "o";
        //**** 开启作弊模式 *****//
        while(open == "ok"){System.out.println(num);break;}
        //**** 开启作弊模式 *****//

        GuessNub gn = new GuessNub();
        gn.doIt();
    }
    public void doIt(){
        int a;
        do {
            System.out.println("请输入一个数:");
            a = getNum();
            ++t;
        } while (gudge(a) == 0);
    }

    public static int getNum(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        return num;
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
            System.out.println("你猜小啦！");
            return 0;}
        else {
            System.out.println("你猜大了！");
            return 0;
        }
        return 0;
    }

}
