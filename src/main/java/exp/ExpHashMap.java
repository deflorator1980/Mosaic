package exp;

import dao.Result;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by a on 20.09.16.
 */
public class ExpHashMap {
    static HashMap<Integer, Result> hashMap = new HashMap<>();
    static TreeSet<Integer> treeSet = new TreeSet<>();

    public void addResult(Result result) {
        int freePlaces = result.getFreePlaces();
        hashMap.put(freePlaces, result);
        treeSet.add(freePlaces);
        System.out.println("addResult: " + result);
    }

    public Result getMin() {
        return hashMap.get(treeSet.first());
    }

    public HashMap getResult() {
        return hashMap;
    }
}
