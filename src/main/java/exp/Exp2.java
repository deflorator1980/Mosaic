package exp;

import dao.Result;

import java.util.TreeMap;

/**
 * Created by a on 20.09.16.
 */
public class Exp2 {
    static TreeMap<Integer, Result> treeMap = new TreeMap<>();

    public void addResult(Result result) {
        treeMap.put(result.getFreePlaces(), result);
    }

    public TreeMap<Integer, Result> getResult() {
        return treeMap;
    }

    public Result getMin() {
        Result result = new Result();
        result = treeMap.get(treeMap.firstKey());
        System.out.println("result: " + result);
        return result;
    }
}
