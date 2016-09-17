package h;

/**
 * Created by a on 16.09.16.
 */
public class MultiArray {
    int SIZE = 6;
    char[][] graph = new char[SIZE][SIZE];
    boolean two = true;
    boolean five = true;
    boolean one = true;
    boolean three = true;
    boolean six = true;
    boolean four = true;
    boolean seven = true;
    boolean eight = true;


    public MultiArray() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

//        graph[0][0] = '4';
//        graph[1][0] = '4';
//        graph[0][1] = '4';


        graph[1][1] = '0';
        graph[2][0] = '0';
        graph[0][2] = '0';
        graph[0][3] = '0';
        graph[0][4] = '0';
        graph[0][5] = '0';

        graph[1][2] = '0';
        graph[1][3] = '0';
        graph[1][4] = '0';
//        graph[1][5] = '0';

        graph[3][4] = '0';
//        graph[2][2] = '0';
//        graph[2][0] = '0';
//        graph[3][1] = '0';

//        graph[2][4] = '+';
//        graph[2][5] = '+';
//        graph[3][4] = '+';


//        for (int vert = 0; vert < SIZE; vert++) {
//            for (int h = 0; h < SIZE; h++) {
//                if (graph[vert][h] == '#') {
//                    if (two || five) {
//                        tryTwoFive(vert, h);
//                    } else if (one) {
//                        tryOne(vert, h);
//                    } else if (three || six) {
//                        tryThreeSix(vert, h);
//                    } else
//                        if (four || seven || eight) {
//                        tryFourSevenEight(vert, h);
//                    }
//                }
//            }
//        }

        tryTwoFive();
        tryOne();
        tryThreeSix();
        tryFourSevenEight();

        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                System.out.print(graph[v][h]);
            }
            System.out.println();
        }
    }

    public void tryTwoFive() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                tryTwoFive(v, h);
            }
        }
    }

    public void tryOne() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                tryOne(v, h);
            }
        }
    }

    public void tryThreeSix() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                tryThreeSix(v, h);
            }
        }
    }

    public void tryFourSevenEight() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                tryFourSevenEight(v, h);
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
//        } else if ((hor < SIZE + 2) && (vert < SIZE + 1) && (graph[vert][hor + 1] == '#')
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
        }
    }

    public static void main(String[] args) {
        new MultiArray();
    }
}