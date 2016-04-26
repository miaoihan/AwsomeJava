package MultiThreading;

/**
 * Created by han on 16-4-25.
 */
public class SyncCounter1 {
    public static void main(String[] args) {
        Num num = new Num();
        new Counter(num);
        new Counter(num);
        for (int i = 0; i < 10; i++) {
            num.testEquals();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Num{
    private int x = 0;
    private int y = 0;
    synchronized void increase(){
        x++;
        y++;
    }
    synchronized void testEquals(){
        System.out.println(x+","+y+":"+(x==y));
    }

}

class Counter extends Thread{
    private Num num;
    Counter(Num num){
        this.num = num;
        this.start();
    }

    @Override
    public void run() {
        while(true){
            num.increase();
        }
    }
}
