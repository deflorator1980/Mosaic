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


    @RequestMapping(value = "/getGame", method = RequestMethod.POST)
    public Game2 getGame(@RequestParam("figure") Character fig, @RequestParam("coordinates") Integer coord) {
        return new Game2(fig, new Coordinates(coord, coord));
    }


    @RequestMapping(value = "/getGame0", method = RequestMethod.POST)
    public Game getGame0(@RequestParam("figure") Character fig, @RequestParam("coordinates") Integer coord) {
        Coordinates xy = new Coordinates();
        xy.setHor(coord);
        xy.setVert(coord);
        Coordinates xy2 = new Coordinates();
        xy2.setHor(coord+1);
        xy2.setVert(coord+1);
        List<Coordinates> coordinates = new ArrayList<>();
        coordinates.add(xy);
        coordinates.add(xy2);
        return new Game(fig, coordinates);
    }

    @RequestMapping(value = "getGame2", method = RequestMethod.POST)
    public Game2 getGame2(@RequestBody Game2 game2) {
        return new Game2(game2.getFigure(), game2.getXy());
    }

    @RequestMapping(value = "getGame20", method = RequestMethod.POST)
    public Game getGame20(@RequestBody Game game) {
        return new Game(game.getFigure(), game.getXy());
    }



    @RequestMapping(value = "/tetrominos2", method = RequestMethod.POST)
    public Input2 tetrominos2(@RequestBody Game2 game2) {
        Game2 fakeGame2 = new Game2();
        fakeGame2.setFigure(game2.getFigure());
        fakeGame2.setXy(game2.getXy());
        List<Game2> tetrominos2 = new ArrayList<>();
        tetrominos2.add(game2);
        tetrominos2.add(fakeGame2);
        return new Input2(tetrominos2);
    }

    @RequestMapping(value = "/tetrominos", method = RequestMethod.POST)
    public Input tetrominos(@RequestBody Game game) {
        Game fakeGame = new Game();
        fakeGame.setFigure(game.getFigure());
        fakeGame.setXy(game.getXy());
        List<Game> tetrominos = new ArrayList<>();
        tetrominos.add(game);
        tetrominos.add(fakeGame);
        return new Input(tetrominos);
    }



    @RequestMapping(value = "/response2", method = RequestMethod.POST)
    public Result response2(@RequestBody Input2 input2) {
        MultiArray multiArray = new MultiArray();
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

        for (Game2 game2 : input2.getTetraminos()) {
            multiArray.playersConfig2(game2);
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
