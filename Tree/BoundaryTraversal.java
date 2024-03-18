package Tree;

import java.util.*;

public class BoundaryTraversal {
}

class Solution_BoundaryTraversal {
    List<Integer> idxs = new ArrayList<>();
    ArrayList <Integer> boundary(Node node)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        recur(node, 0, ans);
        return ans;
    }
    void recur(Node root, int level, ArrayList<Integer> list) {
        if(root==null) return;
        if(isLeaf(root)) {
            list.add(root.data);
            idxs.add(level);
        } else if(!idxs.contains(level)) {
            list.add(root.data);
            idxs.add(level);
        }
        recur(root.left, level-1, list);
        recur(root.right, level+1, list);
    }
    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}