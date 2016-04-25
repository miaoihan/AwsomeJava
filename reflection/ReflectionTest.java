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
            System.out.println("{\n");
            printConstructors(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * print all constructors
     * @param cl
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
}
