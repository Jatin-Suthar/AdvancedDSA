package Tree;

public class SumTree {
}

class Solution_SumTree
{
    boolean flag = true;
    boolean isSumTree(Node root)
    {
        recur(root);
        return flag;
    }
    int recur(Node root) {
        if(root == null) return 0;
        if(isLeaf(root)) return root.data;
        int res = recur(root.left) + recur(root.right);
        if(root.data != res) flag = false;
        return res+root.data;
    }
    boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }
}