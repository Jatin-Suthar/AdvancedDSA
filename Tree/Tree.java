package Tree;

import java.util.*;
import java.util.stream.Collectors;

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class Tree
{
    Map<Integer, List<Integer>> map = new HashMap<>();
    public ArrayList<Integer> reverseLevelOrder(Node node)
    {
        recur(node, 0);
        List<List<Integer>> list = new ArrayList<>(map.values());
        Collections.reverse(list);

        return (ArrayList<Integer>) list.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
    public void recur(Node node, int level) {
        if(node==null) return;
        if(map.get(level)!=null) {
            List<Integer> list = map.get(level);
            list.add(node.data);
            map.put(level, list);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            map.put(level, list);
        }
        recur(node.left, level+1);
        recur(node.right, level+1);
    }

    public static void inOrderTraversal(Node node, List<Integer> list) {
        if(node == null) return;
        list.add(node.data);
        inOrderTraversal(node.left, list);
        inOrderTraversal(node.right, list);
    }

}

