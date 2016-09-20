package exp;

import dao.Coordinates;
import dao.Result;

import java.util.*;

/**
 * Created by a on 19.09.16.
 */
public class Exp {
    public static void main(String[] args) {
//        Random rnd = new Random();
//        for (int i = 0; i < 10; i++)
//            System.out.println(rnd.nextInt(4));
//************************************************************
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(1, 20);
//        treeMap.put(5, 12);
//        treeMap.put(5, 11);
//        treeMap.put(0, 10);
//        treeMap.put(2, 1);
//
//        treeMap.keySet().forEach(System.out::println);
//        System.out.println("first key: " + treeMap.firstKey());
//        System.out.println(treeMap.get(treeMap.firstKey()));
//        treeMap.keySet().forEach(System.out::println);
//**************************************************************

//        List<Coordinates> coords = Arrays.asList(
//                new Coordinates(4, 5), new Coordinates(4, 4), new Coordinates(4, 0), new Coordinates(4, 3)
//        );
//        coords.forEach(System.out::println);
//*******************************************************************
//        Coordinates cord1 = new Coordinates(4, 5);
//        Coordinates cord6 = new Coordinates(4, 5);
//        Coordinates cord2 = new Coordinates(4, 4);
//        Coordinates cord3 = new Coordinates(4, 0);
//        Coordinates cord4 = new Coordinates(4, 3);
//        Coordinates cord5 = new Coordinates(4, 3);
//
//        TreeMap<Integer, Coordinates> treeMap = new TreeMap<>();
//        treeMap.put(cord1.getHor(), cord1);
//        treeMap.put(cord2.getHor(), cord2);
//        treeMap.put(cord3.getHor(), cord3);
//        treeMap.put(cord4.getHor(), cord4);
//        treeMap.put(cord5.getHor(), cord5);
//        treeMap.put(cord6.getHor(), cord6);
//
//        System.out.println(treeMap);
//        System.out.println(treeMap.firstKey());
//************************************************************************
//        Result result1 = new Result();
//        result1.setLine0("9bbb88".toCharArray());
//        result1.setLine1("443338".toCharArray());
//        result1.setLine2("413#77".toCharArray());
//        result1.setLine3("111#7a".toCharArray());
//        result1.setLine4("#2555a".toCharArray());
//        result1.setLine5("#2225a".toCharArray());
//        result1.setFreePlaces(4);
//
//        Result result2 = new Result();
//        result2.setLine0("9#bb#8".toCharArray());
//        result2.setLine1("443338".toCharArray());
//        result2.setLine2("413#77".toCharArray());
//        result2.setLine3("111#7a".toCharArray());
//        result2.setLine4("#2555a".toCharArray());
//        result2.setLine5("#2225a".toCharArray());
//        result2.setFreePlaces(6);
//
//        Result result3 = new Result();
//        result3.setLine0("##bb88".toCharArray());
//        result3.setLine1("443338".toCharArray());
//        result3.setLine2("413977".toCharArray());
//        result3.setLine3("11197a".toCharArray());
//        result3.setLine4("92555a".toCharArray());
//        result3.setLine5("92225a".toCharArray());
//        result3.setFreePlaces(2);
//
//        TreeMap<Integer, Result> treeMap = new TreeMap<>();
//        treeMap.put(result1.getFreePlaces(), result1);
//        treeMap.put(result2.getFreePlaces(), result2);
//        treeMap.put(result3.getFreePlaces(), result3);

//        System.out.println(treeMap);
//----------------------------------------------------------------------------
        TreeMap<Integer, Result> treeMap = new TreeMap<>();

        Result result = new Result();
        result.setLine0("9bbb88".toCharArray());
        result.setLine1("443338".toCharArray());
        result.setLine2("413#77".toCharArray());
        result.setLine3("111#7a".toCharArray());
        result.setLine4("#2555a".toCharArray());
        result.setLine5("#2225a".toCharArray());
        result.setFreePlaces(4);

        treeMap.put(result.getFreePlaces(), result);

        result = new Result();
        result.setLine0("9#bb#8".toCharArray());
        result.setLine1("443338".toCharArray());
        result.setLine2("413#77".toCharArray());
        result.setLine3("111#7a".toCharArray());
        result.setLine4("#2555a".toCharArray());
        result.setLine5("#2225a".toCharArray());
        result.setFreePlaces(6);

        treeMap.put(result.getFreePlaces(), result);

        result = new Result();
        result.setLine0("##bb88".toCharArray());
        result.setLine1("443338".toCharArray());
        result.setLine2("413977".toCharArray());
        result.setLine3("11197a".toCharArray());
        result.setLine4("92555a".toCharArray());
        result.setLine5("92225a".toCharArray());
        result.setFreePlaces(2);

        treeMap.put(result.getFreePlaces(), result);

        System.out.println(treeMap);
    }
}
