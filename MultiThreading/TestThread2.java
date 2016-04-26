package MultiThreading;

/**
 * Created by han on 16-4-5.
 */
public class TestThread2 {
    int a;
    public static void main(String[] args) {
        MyTask1 m1 = new MyTask1();
         new Thread(m1,"p1").start();
         new Thread(m1,"p2").start();

    }

}

class MyTask1 implements Runnable{

    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            i++;
            System.out.println(Thread.currentThread().getName() + ":" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
        //System.out.println(a+=2);
    }


