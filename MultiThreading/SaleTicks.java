package MultiThreading;

import java.util.ArrayList;

/**
 * Created by han on 16-4-12.
 */
public class SaleTicks {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new TicketSeller().start();

        }
    }
}

class TicketSeller extends Thread {

    private static int ticket = 100;
    private static Object lock = new Object();

    public void run() {
        while (true) {
            synchronized (this) {
                /************ 每次售票前进行判断 ************/
                if (ticket == 0) {
                    break;
                }

                /************ 符合条件后进行售票 ************/
                System.out.println(Thread.currentThread().getName() + " 售出了第　" + ticket-- + "　张票");
            }
        }
    }
}


