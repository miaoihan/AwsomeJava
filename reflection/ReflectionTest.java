package reflection;


import java.lang.reflect.*;
import java.util.*;

/**
 * reflection program to print all class info
 * Created by han on 16-4-25.
 */
public class ReflectionTest {
    public static void main(String[] args) {
        /** read class name from command or user input */
        String name;
        if (args.length > 0) name = args[0];
        else{
            Scanner sc = new Scanner(System.in);
            System.out.println("enter class name:");
            name = sc.next();
        }
        /** print class and superclass name (!=Object) */
        try {
            Class cl = Class.forName(name);
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (null != supercl && supercl != Objects.class)
                System.out.print(" extends "+supercl.getName());
            System.out.println("{");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
//            Fields fd = cl.getDeclaredField();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);

    }

    /**
     * print all constructors
     * @param cl a class
     */
    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors){
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(name+"(");

            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(" , ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all Methods
     * @param cl a class
     */
    public static void printMethods(Class cl){
        Method[] methons = cl.getDeclaredMethods();
        for (Method m : methons) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.print(retType.getName()+" "+name+"(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all fields
     * @param cl
     */
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();
        for (Field f:fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length()>0) System.out.print(modifiers+" ");
            System.out.println(type.getName()+" "+name+";");
        }
    }


}
