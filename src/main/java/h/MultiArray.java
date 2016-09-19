package h;

import dao.Coordinates;
import dao.Figure;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by a on 16.09.16.
 */
@Repository
public class MultiArray {
    static int SIZE = 6;
//    static char[][] graph = new char[SIZE][SIZE];
    static char[][] graph = new char[SIZE][SIZE];
    boolean two = true;
    boolean five = true;
    boolean one = true;
    boolean three = true;
    boolean six = true;
    boolean four = true;
    boolean seven = true;
    boolean eight = true;
    boolean a = true;
    boolean b = true;
    boolean nine = true;

    public void playersConfig(Figure figure) {
        for (Coordinates coordinates : figure.getXy()) {
            graph[coordinates.getVert()][coordinates.getHor()] = figure.getFigure();
        }
        unavailable(figure.getFigure());
    }

    public void prepareField() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }
    }

    public int countFreePlaces() {
        int count = 0;
        MultiArray multiArray = new MultiArray();
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if(graph[v][h] == '#') count++;
            }
        }
        return count;
    }

    public void availability() {
        List<Boolean> figures = Arrays.asList(one, two, three, four, five, six, seven, eight, nine, a, b);
        figures.forEach(System.out::println);
    }

    public void tryTwoFive() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryTwoFive(v, h);
            }
        }
    }

    public void tryOne() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryOne(v, h);

            }
        }
    }

    public void tryThreeSix() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryThreeSix(v, h);
            }
        }
    }

    public void tryFourSevenEight() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryFourSevenEight(v, h);
            }
        }
    }

    public void tryAB() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryAB(v, h);
            }
        }
    }

    public void tryNine() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[v][h] == '#')
                    tryNine(v, h);
            }
        }
    }


    public void tryTwoFive(int vert, int hor) {
        char figure;
        if (two) {
            figure = '2';
        } else if (five) {
            figure = '5';
        } else return;
        if ((vert < (SIZE - 1)) && (graph[vert + 1][hor] == '#')) {
            if ((hor < (SIZE - 1)) && (graph[vert + 1][hor + 1] == '#')) {
                if ((hor < (SIZE - 2)) && (graph[vert + 1][hor + 2] == '#')) {
                    graph[vert][hor] = figure;
                    graph[vert + 1][hor] = figure;
                    graph[vert + 1][hor + 1] = figure;
                    graph[vert + 1][hor + 2] = figure;
                    unavailable(figure);
                }
            } else if ((vert < (SIZE - 2) && (graph[vert + 2][hor] == '#'))) {
                if ((hor > 0) && (graph[vert + 2][hor - 1] == '#')) {
                    graph[vert][hor] = figure;
                    graph[vert + 1][hor] = figure;
                    graph[vert + 2][hor] = figure;
                    graph[vert + 2][hor - 1] = figure;
                    unavailable(figure);
                }
                if ((hor < (SIZE - 1)) && (graph[vert][hor + 1] == '#')) {
                    graph[vert][hor] = figure;
                    graph[vert + 1][hor] = figure;
                    graph[vert + 2][hor] = figure;
                    graph[vert][hor + 1] = figure;
                    unavailable(figure);
                }
            }
        } else if ((hor < (SIZE - 2)) && (vert < (SIZE - 1)) && (graph[vert][hor + 1] == '#')
                && (graph[vert][hor + 2] == '#')
                && (graph[vert + 1][hor + 2] == '#')) {
            graph[vert][hor] = figure;
            graph[vert][hor + 1] = figure;
            graph[vert][hor + 2] = figure;
            graph[vert + 1][hor + 2] = figure;
            unavailable(figure);
        }

    }

    public void tryOne(int vert, int hor) {
        if (!one) {
            return;
        }
        if (vert < (SIZE - 1) && (graph[vert + 1][hor] == '#')) {
            if ((hor < (SIZE - 1))
                    && (hor > 0)
                    && (graph[vert + 1][hor + 1] == '#')
                    && (graph[vert + 1][hor - 1] == '#')) {
                graph[vert][hor] = '1';
                graph[vert + 1][hor] = '1';
                graph[vert + 1][hor + 1] = '1';
                graph[vert + 1][hor - 1] = '1';
                unavailable('1');
            } else if (hor < (SIZE - 1)
                    && (vert < (SIZE - 2))
                    && (graph[vert + 1][hor + 1] == '#')
                    && ((graph[vert + 2][hor] == '#'))) {
                graph[vert][hor] = '1';
                graph[vert + 1][hor] = '1';
                graph[vert + 2][hor] = '1';
                graph[vert + 1][hor + 1] = '1';
                unavailable('1');
            } else if ((hor > 0)
                    && (hor < (SIZE - 1))
                    && (graph[vert][hor + 1] == '#')
                    && (graph[vert][hor - 1] == '#')) {
                graph[vert][hor] = '1';
                graph[vert + 1][hor] = '1';
                graph[vert][hor - 1] = '1';
                graph[vert][hor + 1] = '1';
                unavailable('1');
            } else if ((vert < (SIZE - 2))
                    && (hor > 0)
                    && (graph[vert + 2][hor] == '#')
                    && (graph[vert + 1][hor - 1] == '#')) {
                graph[vert][hor] = '1';
                graph[vert + 1][hor] = '1';
                graph[vert + 1][hor - 1] = '1';
                graph[vert + 2][hor] = '1';
                unavailable('1');
            }
        }
    }

    public void tryThreeSix(int vert, int hor) {
        char figure;
        if (three) {
            figure = '3';
        } else if (six) {
            figure = '6';
        } else return;
        if ((vert < (SIZE - 1) && (graph[vert + 1][hor] == '#'))) {
            if ((hor > 1)
                    && (graph[vert + 1][hor - 2] == '#')
                    && (graph[vert + 1][hor - 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert + 1][hor - 2] = figure;
                graph[vert + 1][hor - 1] = figure;
                unavailable(figure);
            } else if ((vert < (SIZE - 2)) && (hor > 0)
                    && (graph[vert + 2][hor] == '#')
                    && (graph[vert][hor - 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert + 2][hor] = figure;
                graph[vert][hor - 1] = figure;
                unavailable(figure);
            } else if (hor < (SIZE - 2)
                    && (graph[vert][hor + 1] == '#')
                    && (graph[vert][hor + 2] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert][hor + 1] = figure;
                graph[vert][hor + 2] = figure;
                unavailable(figure);
            } else if ((vert < (SIZE - 2)) && (hor < (SIZE - 1))
                    && (graph[vert + 2][hor] == '#')
                    && (graph[vert + 2][hor + 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert + 2][hor] = figure;
                graph[vert + 2][hor + 1] = figure;
                unavailable(figure);
            }
        }
    }

    public void tryFourSevenEight(int vert, int hor) {
        char figure;
        if (four) {
            figure = '4';
        } else if (seven) {
            figure = '7';
        } else if (eight) {
            figure = '8';
        } else return;

        if ((vert < (SIZE - 1)) && (graph[vert + 1][hor] == '#')) {
            if ((hor < (SIZE - 1)) && (graph[vert + 1][hor + 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert + 1][hor + 1] = figure;
                unavailable(figure);
            } else if ((hor < (SIZE - 1)) && (graph[vert][hor + 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert][hor + 1] = figure;
                unavailable(figure);
            } else if ((hor > 0) && (graph[vert + 1][hor - 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert + 1][hor - 1] = figure;
                unavailable(figure);
            } else if ((hor > 0) && (graph[vert][hor - 1] == '#')) {
                graph[vert][hor] = figure;
                graph[vert + 1][hor] = figure;
                graph[vert][hor - 1] = figure;
                unavailable(figure);
            }
        }
    }

    public void tryAB(int vert, int hor) {
        char figure;
        if (a) {
            figure = 'a';
        } else if (b) {
            figure = 'b';
        } else return;

        if ((vert < (SIZE - 2))
                && (graph[vert + 1][hor] == '#')
                && (graph[vert + 2][hor] == '#')) {
            graph[vert][hor] = figure;
            graph[vert + 1][hor] = figure;
            graph[vert + 2][hor] = figure;
            unavailable(figure);
        } else if ((hor < (SIZE - 2))
                && (graph[vert][hor + 1] == '#')
                && (graph[vert][hor + 2] == '#')) {
            graph[vert][hor] = figure;
            graph[vert][hor + 1] = figure;
            graph[vert][hor + 2] = figure;
            unavailable(figure);
        }
    }

    public void tryNine(int vert, int hor) {
        if (!nine) {
            return;
        }
        graph[vert][hor] = '9';
        unavailable('9');
    }

    public void unavailable(char figure) {
        if (figure == '2') {
            two = false;
        } else if (figure == '5') {
            five = false;
        } else if (figure == '1') {
            one = false;
        } else if (figure == '3') {
            three = false;
        } else if (figure == '6') {
            six = false;
        } else if (figure == '4') {
            four = false;
        } else if (figure == '7') {
            seven = false;
        } else if (figure == '8') {
            eight = false;
        } else if (figure == 'a') {
            a = false;
        } else if (figure == 'b') {
            b = false;
        } else if (figure == '9') {
            nine = false;
        }
    }

}