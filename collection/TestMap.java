package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 用HashMap统计随机分布
 * Created by han on 16-4-19.
 */
public class TestMap {
    public static void main(String[] args) {
        Random rand = new Random();
        Map<Integer,Integer> map= new HashMap<Integer,Integer>();
        for (int i = 0; i < 1000000; i++) {
            int r = rand.nextInt(20);
            Integer time = map.get(r);
            map.put(r, time == null ? 1 : time+1);
        }
        System.out.println(map);
    }
}
