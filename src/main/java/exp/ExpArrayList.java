package exp;

import dao.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by a on 20.09.16.
 */
public class ExpArrayList {
    static List<Result> list = new ArrayList<>();
    Exp2 exp2 = new Exp2();

    public void addResult(Result result) {
        System.out.println("addResult: " + result);
        list.add(result);
    }

    public List getResult() {
        return list;
    }

    public Result getMin() {
        for (Result result : list) {
            exp2.addResult(result);
        }
        System.out.println("list: " + list);
        return exp2.getMin();
    }
}
