package MultiThreading;

/**
 * Created by han on 16-4-5.
 */
public class TestThread1 {
    public static int a = 3;
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread2();
        t1.start();
        t2.start();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 25 ; i++) {
            System.out.print(i+" ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(TestThread1.a+=2);
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (char i='a'; i<='z'; i++){
            System.out.print(i+" ");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(TestThread1.a+=2);
    }
}
