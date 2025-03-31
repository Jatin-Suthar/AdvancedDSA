package Tree;

import java.util.*;

public class BottomView {
}

class Solution_BottomView
{
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        if(root==null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair_BottomView> queue = new LinkedList<>();
        queue.add(new Pair_BottomView(root, 0));
        while(!queue.isEmpty()) {
            Pair_BottomView p = queue.poll();
            Node node = p.node;
            int level = p.level;
            map.computeIfAbsent(level, k -> node.data);
            if(node.left!=null) {
                queue.add(new Pair_BottomView(node.left, level-1));
            }
            if(node.right!=null) {
                queue.add(new Pair_BottomView(node.right, level+1));
            }
        }
        return new ArrayList<>(map.values());
    }
    
}

class Pair_BottomView {
    Node node;
    int level;
    public Pair_BottomView(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}