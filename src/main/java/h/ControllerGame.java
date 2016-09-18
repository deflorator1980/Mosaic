package h;

import dao.Game;
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

}
