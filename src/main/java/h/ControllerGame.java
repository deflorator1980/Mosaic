package h;

import dao.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for (Game game : input.getTetrominos()) {
            multiArray.playersConfig(game);
        }

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

        for (int h = 0; h < SIZE; h++) {
            abc0[h] = graph[0][h];
        }
        for (int h = 0; h < SIZE; h++) {
            abc1[h] = graph[1][h];
        }
        for (int h = 0; h < SIZE; h++) {
            abc2[h] = graph[2][h];
        }
        for (int h = 0; h < SIZE; h++) {
            abc3[h] = graph[3][h];
        }
        for (int h = 0; h < SIZE; h++) {
            abc4[h] = graph[4][h];
        }
        for (int h = 0; h < SIZE; h++) {
            abc5[h] = graph[5][h];
        }

        return new Result(abc0, abc1, abc2, abc3, abc4, abc5);
    }

}
