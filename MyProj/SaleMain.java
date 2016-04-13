package MyProj;

/**
 * Created by han on 16-4-13.
 */
public class SaleMain {
    public static void main(String[] args) {
        SaleTickets st = new SaleTickets();
        for(int i=1; i<=5; i++) {
            new Thread(st, "售票点" + i).start();
        }
    }
}
