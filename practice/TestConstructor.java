package practice;

/**
 * Author han on 16-3-25.
 */
public class TestConstructor {
    int age;
    int sex;

    public TestConstructor(int age) {
        this.age = age;

    }

    public TestConstructor(int age, int sex){
        this.age = age;
        this.sex = sex;
        Object obj = new TestConstructor(2);
        Class cla= obj.getClass();
//        cla = obj.ge
        System.out.println("name is "+cla.getName());

    }

    public void doStuff(){
//        TestConstructor t = new TestConstructor(2,6);
        Object obj = new TestConstructor(2,0);
        Class cla= obj.getClass();
        System.out.println("name is"+cla.getName());
//        System.out.println("do it！");

    }

    public static void main(String[] args) {
        TestConstructor t = new TestConstructor(2,6);
//        t.doStuff();

    }

}
