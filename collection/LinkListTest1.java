package collection;

import pojo.Person;

/**
 * time: 16-5-12.
 * author: han
 */
public class LinkListTest1 {
    public static void main(String[] args) {
        Person p1 = new Person("han",1);
        Person p2 = new Person("zh",2);
        Person p3 = new Person("阿龙",3);
        Person p4 = new Person("阿辉",4);
        p1.next = p2;
        p2.next = p4;
        p4.next = p3;
//        while (p1.hasNext()){
//            System.out.println(p1.name);
//            p1 = p1.next;
//        }
        Iterable iter = Person.i
    }


}
