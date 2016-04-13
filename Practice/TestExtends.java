package Practice;

/**
 * Created by han on 16-3-28.
 * 多态 动态绑定（虚方法调用）
 */
public class TestExtends {
    static void doIt(Person p){
        p.sayHello();
    }

    public static void main(String[] args) {
//        Person P = new Person();
        Student s = new Student();
        Teacher t = new Teacher();
        Work w = new Work();
        doIt(t);
        doIt(s);
        doIt(w);
    }
}

class Person{
    void sayHello(){
        System.out.println("I am a Person");
    }
}

class Student extends Person{
    void sayHello(){
        System.out.println("I am a student");
    }
}

class Teacher extends Person{
    void sayHello(){
        System.out.println("I am a teacher");
    }
}

class Work extends Person{
    void sayHello(){
        System.out.println("I am a work");
    }
}
