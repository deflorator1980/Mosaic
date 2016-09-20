package h;

import dao.*;
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
import static h.MultiArray.graph;

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


        return new Result(graph[0], graph[1], graph[2], graph[3], graph[4], graph[5], multiArray.countFreePlaces());
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
        return new Result(graph[0], graph[1], graph[2], graph[3], graph[4], graph[5], multiArray.countFreePlaces());
//        return new Result(graph[0], graph[1], graph[2], graph[3], graph[4], graph[5]);

    }

    @RequestMapping(value = "/multirnd", method = RequestMethod.POST)
    public Result multiRnd(@RequestBody Input input) {

        TreeMap<Integer, Result> resultsCollection = new TreeMap<>();
//        Result result;
        for (int i = 0; i < 10; i++) {
            Result result = new Result();
            result = rnd(input);
            if (result != null) {
                System.out.print(result.getFreePlaces());
//                System.out.print(MultiArray.countFreePlaces());
                System.out.println(" " + result);
                System.out.println(result.hashCode());
                resultsCollection.put(result.getFreePlaces(), result);
//                resultsCollection.put(MultiArray.countFreePlaces(), result);
                if (result.getFreePlaces() == 0) {
//                if (MultiArray.countFreePlaces() == 0) {
                    System.out.println(MultiArray.countFreePlaces());
                    System.out.println(resultsCollection);
                    return result;
                }
            }
        }
        System.out.println(resultsCollection);
        return resultsCollection.get(resultsCollection.firstKey());
    }

}
