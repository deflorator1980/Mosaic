package h;

import java.util.Random;

/**
 * Created by a on 19.09.16.
 */
public class Exp {
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < 10; i++)
            System.out.println(rnd.nextInt(4));

    }
}
