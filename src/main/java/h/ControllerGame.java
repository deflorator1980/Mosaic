package h;

import dao.Game;
import dao.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a on 18.09.16.
 */
@RestController
public class ControllerGame {

    @RequestMapping("/")
    public Game show() {
//        return new Game("mosaic");
        MultiArray multiArray = new MultiArray();
        multiArray.availability();
        Map<Integer, Integer> coords = new HashMap<>();
        coords.put(2, 4);
        coords.put(3, 5);
        return new Game('1', coords);
    }

    @RequestMapping(value = "/move", method = RequestMethod.POST)
    public Game move(@RequestParam("figure") Character fig, @RequestParam("coordinates") Integer coord) {
        Map<Integer, Integer> coords = new HashMap<>();
        coords.put(coord, coord);
        return new Game('1', coords);
    }

    @RequestMapping(value = "/move2", method = RequestMethod.POST)
    public Game move2(@RequestBody Game game) {
//        Map<Integer, Integer> coords = new HashMap<>();
//        coords.put(val, val);
//        return new Game('1', coords);
        return new Game(game.getFigure(), game.getCoordinates());
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public Result result(@RequestBody Game game) {
//        char[] abc = {'a', 'b', 'c'};
        MultiArray multiArray = new MultiArray();
        char[] abc0 = new char[multiArray.SIZE];
        char[] abc1 = new char[multiArray.SIZE];
        char[] abc2 = new char[multiArray.SIZE];
        char[] abc3 = new char[multiArray.SIZE];
        char[] abc4 = new char[multiArray.SIZE];
        char[] abc5 = new char[multiArray.SIZE];
        for (int h = 0; h < multiArray.SIZE; h++) {
            abc0[h] =multiArray.graph[0][h];
        }
        for (int h = 0; h < multiArray.SIZE; h++) {
            abc0[h] =multiArray.graph[0][h];
        }for (int h = 0; h < multiArray.SIZE; h++) {
            abc1[h] =multiArray.graph[1][h];
        }for (int h = 0; h < multiArray.SIZE; h++) {
            abc2[h] =multiArray.graph[2][h];
        }for (int h = 0; h < multiArray.SIZE; h++) {
            abc3[h] =multiArray.graph[3][h];
        }for (int h = 0; h < multiArray.SIZE; h++) {
            abc4[h] =multiArray.graph[4][h];
        }
        for (int h = 0; h < multiArray.SIZE; h++) {
            abc5[h] =multiArray.graph[5][h];
        }
        return new Result(abc0, abc1, abc2, abc3, abc4, abc5);
//        return new Result(abc);
    }

}
