package h;

import dao.Game;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping("/move")
//    public Game move(@RequestParam(value = "figure") Character fig) {
//
//    }

}
