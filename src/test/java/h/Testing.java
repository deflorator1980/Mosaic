package h;

import dao.Coordinates;
import dao.Figure;
import dao.Input;
import dao.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by a on 19.09.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class Testing {

    @Autowired
    MultiArray multiArray;

    @Autowired
    ControllerGame controllerGame;

    @Test
    public void testInfill() {
        Result result = new Result();

        String l0 = "442555";
        char[] line0 = l0.toCharArray();
        result.setLine0(line0);

        String l1 = "412225";
        char[] line1 = l1.toCharArray();
        result.setLine1(line1);

        String l2 = "111377";
        char[] line2 = l2.toCharArray();
        result.setLine2(line2);

        String l3 = "633378";
        char[] line3 = l3.toCharArray();
        result.setLine3(line3);

        String l4 = "6aaa88";
        char[] line4 = l4.toCharArray();
        result.setLine4(line4);

        String l5 = "66bbb9";
        char[] line5 = l5.toCharArray();
        result.setLine5(line5);

        result.setFreePlaces(0);

        Figure figure = new Figure();
        figure.setFigure('4');
        figure.setXy(Arrays.asList(
                new Coordinates(0, 0),
                new Coordinates(0, 1),
                new Coordinates(1, 0)));

        Figure figure2 = new Figure();
        figure2.setFigure('7');
        figure2.setXy(Arrays.asList(
                new Coordinates(2, 4),
                new Coordinates(2, 5),
                new Coordinates(3, 4)));

        Input input = new Input(Arrays.asList(figure, figure2));

        assertEquals(result, controllerGame.response(input));
    }

    @Test
    public void checkAvailability() {
        multiArray.availability();
    }

}
