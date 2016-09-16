package h;

/**
 * Created by a on 16.09.16.
 */
public class MultiArray {
    int SIZE = 6;
    char[][] graph = new char[SIZE][SIZE];

    public MultiArray() {
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

        graph[0][0] = '+';
        graph[1][0] = '+';
        graph[0][1] = '+';


//        graph[0][3] = '+';
//        graph[2][4] = '+';
//        graph[2][5] = '+';
//        graph[3][4] = '+';


        int vert = 0;
        for (int h = 0; h < SIZE; h++) {
            if (graph[vert][h] == '#') {
                tryTwoFive(vert, h);
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
        if ((vert < (SIZE - 1)) && (graph[vert + 1][hor] == '#')) {
            if ((hor < (SIZE - 1)) && (graph[vert + 1][hor + 1] == '#')) {
                if ((hor < (SIZE - 2)) && (graph[vert + 1][hor + 2] == '#')) {
                    graph[vert][hor] = '+';
                    graph[vert + 1][hor] = '+';
                    graph[vert + 1][hor + 1] = '+';
                    graph[vert + 1][hor + 2] = '+';
                }
            } else if ((vert < (SIZE - 2) && (graph[vert + 2][hor] == '#'))) {
                if ((hor > 0) && (graph[vert + 2][hor - 1] == '#')) {
                    graph[vert][hor] = '+';
                    graph[vert + 1][hor] = '+';
                    graph[vert + 2][hor] = '+';
                    graph[vert + 2][hor - 1] = '+';
                }
                if ((hor < (SIZE - 1)) && (graph[vert][hor + 1] == '#')) {
                    graph[vert][hor] = '+';
                    graph[vert + 1][hor] = '+';
                    graph[vert + 2][hor] = '+';
                    graph[vert][hor + 1] = '+';
                }
            }
        } else if ((hor < SIZE + 2) && (vert < SIZE + 1) && (graph[vert][hor + 1] == '#')
                && (graph[vert][hor + 2] == '#')
                && (graph[vert + 1][hor + 2] == '#')) {
            graph[vert][hor] = '+';
            graph[vert][hor + 1] = '+';
            graph[vert][hor + 2] = '+';
            graph[vert + 1][hor + 2] = '+';
        }
    }

    public static void main(String[] args) {
        new MultiArray();
    }
}