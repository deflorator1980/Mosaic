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


    public MultiArray() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

        graph[0][0] = '4';
        graph[1][0] = '4';
        graph[0][1] = '4';


//        graph[0][3] = '9';
//        graph[2][2] = '9';
//        graph[2][0] = '9';
//        graph[3][1] = '9';

//        graph[2][4] = '+';
//        graph[2][5] = '+';
//        graph[3][4] = '+';


//        int vert = 0;
        for (int vert = 0; vert < 2; vert++) {
            for (int h = 0; h < SIZE; h++) {
                if (graph[vert][h] == '#') {
                    if (two || five) {
                        tryTwoFive(vert, h);
                    } else if (one) {
                        oneOnly(vert, h);
                    }
                }
            }
        }
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                System.out.print(graph[v][h]);
            }
            System.out.println();
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
        } else if ((hor < SIZE - 2) && (vert < SIZE - 1) && (graph[vert][hor + 1] == '#')
                && (graph[vert][hor + 2] == '#')
                && (graph[vert + 1][hor + 2] == '#')) {
            graph[vert][hor] = figure;
            graph[vert][hor + 1] = figure;
            graph[vert][hor + 2] = figure;
            graph[vert + 1][hor + 2] = figure;
            unavailable(figure);
        }

    }

    public void oneOnly(int vert, int hor) {
        if (vert < (SIZE - 1) && (graph[vert + 1][hor] == '#') ){
                if((hor < (SIZE - 1))
                    && (hor > 0)
                    && (graph[vert + 1][hor + 1] == '#')
                    && (graph[vert + 1][hor - 1] == '#')){
                graph[vert][hor] = '1';
                graph[vert + 1][hor] = '1';
                graph[vert + 1][hor + 1] = '1';
                graph[vert + 1][hor - 1] = '1';
                unavailable('1');
                } else if (hor < (SIZE - 1)
                        &&(vert < (SIZE -2 ))
                        &&(graph[vert + 1][hor + 1] == '#')
                        &&((graph[vert + 2][hor] == '#'))) {
                    graph[vert][hor] = '1';
                    graph[vert + 1][hor] = '1';
                    graph[vert + 2][hor] = '1';
                    graph[vert + 1][hor + 1] = '1';
                    unavailable('1');
                } else if ((hor > 0)
                        &&(hor < (SIZE - 1))
                        &&(graph[vert][hor + 1] == '#')
                        &&(graph[vert][hor - 1] == '#')) {
                    graph[vert][hor] = '1';
                    graph[vert + 1][hor] = '1';
                    graph[vert][hor - 1] = '1';
                    graph[vert][hor + 1] = '1';
                    unavailable('1');
                } else if ((vert < (SIZE -2))
                        && (hor > 0)
                        &&(graph[vert + 2][hor] == '#')
                        &&(graph[vert + 1][hor - 1] == '#')) {
                    graph[vert][hor] = '1';
                    graph[vert + 1][hor] = '1';
                    graph[vert + 1][hor - 1] = '1';
                    graph[vert + 2][hor] = '1';
                    unavailable('1');
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
        }
    }

    public static void main(String[] args) {
        new MultiArray();
    }
}