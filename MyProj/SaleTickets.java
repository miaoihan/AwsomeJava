package MyProj;

import java.util.Random;

public class SaleTickets implements Runnable {

    public int total;
    public int count;

    public SaleTickets() {
        total = 96;
        count = 0;
    }

    public void run() {
//        while (total > 0) {
             {
                while(total > 0) {
                    /************ 每次售票前进行判断 ************/
                    if (total <= 0) {
                        break;
                    }

                    /************ 模拟售票的网络延迟 ************/
                    try {
//Thread.sleep(800);
                        Thread.sleep(new Random().nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    /************ 符合条件后进行售票 ************/
                    count++;
                    total--;

                    System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
                }
//            }
        }
    }

}