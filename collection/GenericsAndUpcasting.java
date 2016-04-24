package collection;

import java.util.ArrayList;

/**
 *
 * Created by han on 16-4-19.
 */
class Fruit{}
class Apple extends Fruit{}
class Banan extends Fruit{}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(new Apple());
        fruits.add(new Banan());
//        for(Fruit f : fruits)
//            System.out.println(f);
        fruits.forEach(System.out::println);
    }

}
