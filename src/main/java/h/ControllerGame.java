package h;

import dao.*;
import exp.Exp2;
import exp.ExpArrayList;
import exp.ExpHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static h.MultiArray.SIZE;

/**
 * Created by a on 18.09.16.
 */
@Repository
@RestController
public class ControllerGame {


    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public Result response(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();

        multiArray.prepareField();

//        for (Figure game : input.getTetrominos()) {
//            multiArray.playersConfig(game);
//        }
        input.getTetrominos().forEach(multiArray::playersConfig);

        multiArray.tryTwoFive();
        multiArray.tryOne();
        multiArray.tryThreeSix();
        multiArray.tryFourSevenEight();
        multiArray.tryAB();
        multiArray.tryNine();


        return new Result(multiArray.graph[0], multiArray.graph[1], multiArray.graph[2], multiArray.graph[3],
                multiArray.graph[4], multiArray.graph[5], multiArray.countFreePlaces());
    }

    @RequestMapping(value = "/rnd", method = RequestMethod.POST)
//    public Result rnd() {
//    public Result rnd(Input input) {
    public Result rnd(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();

        multiArray.prepareField();

        input.getTetrominos().forEach(multiArray::playersConfig);

        Random rnd = new Random();
        multiArray.tryTwoFiveRnd(rnd.nextInt(6), rnd.nextInt(6));
        multiArray.tryOneRnd(rnd.nextInt(6), rnd.nextInt(6));
        multiArray.tryThreeSixRnd(rnd.nextInt(6), rnd.nextInt(6));
        multiArray.tryFourSevenEightRnd(rnd.nextInt(6), rnd.nextInt(6));
        multiArray.tryABRnd(rnd.nextInt(6), rnd.nextInt(6));
        multiArray.tryNineRnd(rnd.nextInt(6), rnd.nextInt(6));
        return new Result(multiArray.graph[0], multiArray.graph[1], multiArray.graph[2],
                multiArray.graph[3], multiArray.graph[4], multiArray.graph[5], multiArray.countFreePlaces());
//        return new Result(graph[0], graph[1], graph[2], graph[3], graph[4], graph[5]);

    }

    @RequestMapping(value = "/multirnd", method = RequestMethod.POST)
    public Result multiRnd(@RequestBody Input input) {
//        Exp2 exp2 = new Exp2();
//        ExpHashMap expHashMap = new ExpHashMap();
        ExpArrayList expArrayList = new ExpArrayList();

//        TreeMap<Integer, Result> treeMap = new TreeMap<>();
//        Result result;
        for (int i = 0; i < 10; i++) {
            Result result = rnd(input);
            if (result != null) {
//                System.out.print(result.getFreePlaces());
//                System.out.print(MultiArray.countFreePlaces());
//                System.out.println(" " + result);
//                System.out.println(result.hashCode());
//                treeMap.put(result.getFreePlaces(), result);
//                exp2.addResult(result);
//                expHashMap.addResult(result);
                expArrayList.addResult(result);

//                resultsCollection.put(MultiArray.countFreePlaces(), result);
                if (result.getFreePlaces() == 0) {
//                if (MultiArray.countFreePlaces() == 0) {
//                    System.out.println(MultiArray.countFreePlaces());
//                    System.out.println(treeMap);
//                    System.out.println(exp2.getResult());
//                    System.out.println(expHashMap.getResult());
//                    System.out.println(expArrayList.getResult());


                    return result;
                }
            }
        }
//        System.out.println(exp2.getResult());
//        System.out.println(expArrayList.getResult());

//        return treeMap.get(treeMap.firstKey());
//        return exp2.getResult().get(exp2.getResult().firstKey());
//        return expHashMap.getMin();
        return expArrayList.getMin();
    }

}
