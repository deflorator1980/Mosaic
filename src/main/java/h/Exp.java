package h;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by a on 19.09.16.
 */
public class Exp {
    public static void main(String[] args) {
//        Random rnd = new Random();
//        for (int i = 0; i < 10; i++)
//            System.out.println(rnd.nextInt(4));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(0, 10);
        treeMap.put(1, 20);

        treeMap.keySet().forEach(System.out::println);
    }
}
