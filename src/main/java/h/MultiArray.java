package h;

/**
 * Created by a on 16.09.16.
 */
public class MultiArray
{
    public static void main(String[] args) {
        int SIZE = 6;
        char[][] graph = new char[SIZE][SIZE];
        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                graph[v][h] = '#';
            }
        }

        graph[0][0] = 0;
        graph[1][0] = 0;
        graph[0][1] = 0;

        graph[2][4] = 0;
        graph[2][5] = 0;
        graph[3][4] = 0;


//        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                                   
            }
//        }

        for (int v = 0; v < SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                System.out.print(graph[v][h]);
            }
            System.out.println();
        }
    }
}