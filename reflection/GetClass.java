package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * time: 16-4-27.
 * author: han
 */
public class GetClass {
    public <T> void getUser(T t){
        Class cl = t.getClass();
//        String name = cl.getName();
//        Method[] methods = cl.getMethods();
        Field[] fields = cl.getDeclaredFields();
//        int len = fields.length;
        try {
            for (Field f : fields) {
                String fname = f.getName();
//                Field fd = cl.getDeclaredField(fname);
                /**  修改访问权限，可以访问private   */
                f.setAccessible(true);
                System.out.println(f);
                System.out.println(fname + " ");
//                System.out.println(fd);
                System.out.println(f.get(t) + " ");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        User user = new User("zhangsan","1234");
        GetClass gt =new GetClass();
        gt.getUser(user);
    }
}
