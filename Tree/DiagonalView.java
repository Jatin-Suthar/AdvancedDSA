package Tree;

import java.util.*;

public class DiagonalView {
}

class DiagonalView_Tree
{
    Map<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
    public ArrayList<Integer> diagonal(Node root) {
        recur(root, 0);
        ArrayList<Integer> res = new ArrayList<>();
        for(List<Integer> value: map.values()) {
            res.addAll(value);
        }
        return res;
    }
    public void recur(Node root, int level) {
        if(root==null) return;
        if(map.get(level)!=null) {
            List<Integer> list = map.get(level);
            list.add(root.data);
            map.put(level, list);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(level, list);
        }
        recur(root.left, level-1);
        recur(root.right, level);
    }
}