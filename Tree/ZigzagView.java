package Tree;

import java.util.*;

public class ZigzagView {
}

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        if(root==null) return new ArrayList<>();
        Queue<Pair_ZigZagView> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        q.add(new Pair_ZigZagView(root, 0));
        while(!q.isEmpty()) {
            Pair_ZigZagView p = q.poll();
            Node node = p.node;
            int level = p.level;
            List<Integer> result = map.getOrDefault(level, Collections.emptyList());
            result.add(node.data);
            if(node.left!=null) {
                q.add(new Pair_ZigZagView(node.left, level+1));
            }
            if(node.right!=null) {
                q.add(new Pair_ZigZagView(node.right, level+1));
            }
        }
        boolean zigzag = true;
        for(List<Integer> values: map.values()) {
            if(zigzag) {
                list.addAll(values);
            } else {
                Collections.reverse(values);
                list.addAll(values);
            }
            zigzag = !zigzag;
        }
        return list;
    }
}

class Pair_ZigZagView {
    Node node;
    int level;
    public Pair_ZigZagView(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}


