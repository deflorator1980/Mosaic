package h;

import dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static h.MultiArray.SIZE;
import static h.MultiArray.graph;

/**
 * Created by a on 18.09.16.
 */
@Repository
@RestController
public class ControllerGame {

    private final AtomicLong counter = new AtomicLong();

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

}
