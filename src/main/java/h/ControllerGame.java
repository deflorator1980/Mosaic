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

    @RequestMapping(value = "/getGame2", method = RequestMethod.POST)
    public Game2 getGame2(@RequestParam("figure") Character fig, @RequestParam("coordinates") Integer coord) {
//        return new Game2('x', new Coordinates(1 ,1));
        return new Game2(fig, new Coordinates(coord, coord));
    }

    @RequestMapping(value = "/move2", method = RequestMethod.POST)
    public Game move2(@RequestBody Game game) {
//        Map<Integer, Integer> coords = new HashMap<>();
//        coords.put(val, val);
//        return new Game('1', coords);
        return new Game(game.getFigure(), game.getCoordinates());
    }


    @RequestMapping(value = "/tetraminos", method = RequestMethod.POST)
    public Input tetraminos(@RequestBody Game game) {
        Game fakeGame = new Game();
        fakeGame.setCoordinates(game.getCoordinates());
        fakeGame.setFigure(game.getFigure());
        List<Game> tetraminos = new ArrayList<>();
        tetraminos.add(game);
        tetraminos.add(fakeGame);
        return new Input(tetraminos);
    }

    @RequestMapping(value = "/input2", method = RequestMethod.POST)
    public Result result2(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

//        Game game = new Game();
//        Map<Integer, Integer> coords = new HashMap<>();
//        coords.put(2, 4);
//        coords.put(3, 5);
//        plyaersConfig(0, coords);
        Game game2 = new Game();
        for (Game game : input.getTetraminos()) {
            multiArray.plyaersConfig(game);
//            game2 = game;
        }
//        multiArray.plyaersConfig(game2);
//
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
//        for (int v = 0; v < SIZE; v++) {
//            for (int h = 0; h < SIZE; h++) {
//                System.out.print(graph[v][h]);
//            }
//            System.out.println();
//        }
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

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public Result input2(@RequestBody Input input) {
        MultiArray multiArray = new MultiArray();
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

        Game game2 = new Game();
        for (Game game : input.getTetraminos()) {
            multiArray.plyaersConfig(game);
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

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public Result result(@RequestBody Game game) {
//        char[] abc = {'a', 'b', 'c'};
        MultiArray multiArray = new MultiArray();
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
//        return new Result(abc);
    }

}
