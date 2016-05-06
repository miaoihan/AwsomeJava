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
        Map<Integer,Integer> map= new HashMap<>();
        /** 产生一百万个数  */
        for (int i = 0; i < 1000000; i++) {
            /** 随机生成0-19 */
            int r = rand.nextInt(20);
            Integer times = map.get(r);
            map.put(r, times == null ? 1 : times+1);
        }
        System.out.println(map);
    }
}
