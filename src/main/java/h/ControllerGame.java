package h;

import dao.*;
import org.springframework.web.bind.annotation.*;

import static h.MultiArray.SIZE;
import static h.MultiArray.graph;

/**
 * Created by a on 18.09.16.
 */
@RestController
public class ControllerGame {

    @RequestMapping(value = "/response", method = RequestMethod.POST)
    public Result response(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

//        for (Game game : input.getTetrominos()) {
//            multiArray.playersConfig(game);
//        }
        input.getTetrominos().forEach(multiArray::playersConfig);

        multiArray.tryTwoFive();
        multiArray.tryOne();
        multiArray.tryThreeSix();
        multiArray.tryFourSevenEight();
        multiArray.tryAB();
        multiArray.tryNine();

        char[] abc0 = new char[SIZE];
        char[] abc1 = new char[SIZE];
        char[] abc2 = new char[SIZE];
        char[] abc3 = new char[SIZE];
        char[] abc4 = new char[SIZE];
        char[] abc5 = new char[SIZE];

//        for (int h = 0; h < SIZE; h++) {
//            abc0[h] = graph[0][h];
//        }

        System.arraycopy(graph[0], 0, abc0, 0, SIZE);
        System.arraycopy(graph[1], 0, abc1, 0, SIZE);
        System.arraycopy(graph[2], 0, abc2, 0, SIZE);
        System.arraycopy(graph[3], 0, abc3, 0, SIZE);
        System.arraycopy(graph[4], 0, abc4, 0, SIZE);
        System.arraycopy(graph[5], 0, abc5, 0, SIZE);

        return new Result(abc0, abc1, abc2, abc3, abc4, abc5);
    }

}
