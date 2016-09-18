package dao;

import java.util.Map;

/**
 * Created by a on 18.09.16.
 */
public class Game {

    Character figure;

    Map<Integer, Integer> coordinates;

    public Game(Character figure, Map<Integer, Integer> coordinates) {
        this.figure = figure;
        this.coordinates = coordinates;
    }

    public Character getFigure() {
        return figure;
    }

    public Map<Integer, Integer> getCoordinates() {
        return coordinates;
    }
}
