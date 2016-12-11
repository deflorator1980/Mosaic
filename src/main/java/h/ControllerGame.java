package h;

import dao.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by a on 18.09.16.
 */
@Repository
@RestController
@Slf4j
public class ControllerGame {


    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public Result response(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();

        multiArray.prepareField();

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

    }

    @RequestMapping(value = "/multirnd", method = RequestMethod.POST)
    public Result multiRnd(@RequestBody Input input) {

        long start = System.currentTimeMillis();

        Result min = new Result();
        min.setFreePlaces(-1);

        for (int i = 0; i < 100; i++) {
            Result result = rnd(input);
            if (result != null) {
                if (result.getFreePlaces() == 0) {
                    long stop = System.currentTimeMillis();
                    System.out.println(stop - start);
                    return result;
                }

                if((min.getFreePlaces() > result.getFreePlaces()) ||(min.getFreePlaces() == -1)){
                    min = result;
                }
            }
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);
        return min;
    }

}
