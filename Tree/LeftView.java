package Tree;

import java.util.*;

public class LeftView {
}

class Solution_LeftView
{
    List<Integer> idxs = new ArrayList<>();
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        return recur(root, 0);
    }
    ArrayList<Integer> recur(Node root, int idx) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        if(!idxs.contains(idx)) {
            list.add(root.data);
            idxs.add(idx);
        }
        if(root.left!=null) {
            list.addAll(recur(root.left, idx+1));
        }
        if(root.right!=null) {
            list.addAll(recur(root.right, idx+1));
        }
        return list;
    }
}