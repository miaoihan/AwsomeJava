package constrctor;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @author han
 * @date 16-5-19.
 */
public class ConstructTest {
    public static void main(String[] args) {
        Person p = new Student("李明",18,"北大");
    }
}

class Person{
    String name = "";
    int age = -1;
    Person(String name, int age){
        this.name = name;
        this.age = age;
        sayHello();
    }
    void sayHello(){
        System.out.println("我是一个人");
    }
}

class Student extends Person{
    String school = "";
    Student(String name, int age, String school){
        super(name,age);
        this.school = school;
    }

    void sayHello(){
        System.out.println("我是学生，叫"+ name + ",年龄："+age+ " ,学校："+school);
    }
}
