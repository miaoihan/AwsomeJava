package Practice;

/**
 * time: 16-5-12.
 * author: han
 */
public class callBack {

    public int add(int a, int b){
        return a + b;
    }

    public int add2(){
        return add(1,2);
    }

    public static void main(String[] args) {
        callBack cb = new callBack();
        System.out.println(cb.add2());
    }
}
