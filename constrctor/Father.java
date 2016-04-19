package constrctor;

/**
 * 子类构造器先调用父类构造器，直到Object类
 * Created by han on 16-4-19.
 */
public class Father {
    public Father() {
        System.out.println("in father");
    }
}

class Son extends Father {
    Son(){
        System.out.println("in son");
    }

}

class Grandson extends Son{
    public Grandson() {
        System.out.println("in grandson");
    }

    public static void main(String[] args) {
        Grandson g = new Grandson();
    }
}


