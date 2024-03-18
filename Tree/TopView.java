package Tree;

import java.util.*;

public class TopView {
}

class Solution_TopView
{
    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        if(root==null) return new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair_TopView> queue = new LinkedList<>();
        queue.add(new Pair_TopView(root, 0));
        while(!queue.isEmpty()) {
            Pair_TopView p = queue.poll();
            Node node = p.node;
            int level = p.level;
            map.computeIfAbsent(level, k -> node.data);
            if(node.left!=null) {
                queue.add(new Pair_TopView(node.left, level-1));
            }
            if(node.right!=null) {
                queue.add(new Pair_TopView(node.right, level+1));
            }
        }
        return new ArrayList<>(map.values());
    }
}

class Pair_TopView {
    Node node;
    int level;
    public Pair_TopView(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}