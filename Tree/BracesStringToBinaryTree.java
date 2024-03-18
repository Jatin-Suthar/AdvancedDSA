package Tree;

import java.util.*;

import static Tree.Solution_BracesStringToBinaryTree.treeFromString;
import static Tree.Tree.inOrderTraversal;

public class BracesStringToBinaryTree {

    public static void main(String[] args) {
        String s = "10(7(3(1(2))(6(5(4))))(9(8)))";
        Node node = treeFromString(s);
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(node, res);
        System.out.println(res);
    }

}

class Solution_BracesStringToBinaryTree {
    public static Node treeFromString(String s) {
        if(s==null || s.isBlank()) { return null; }
        return recur(s, 0);
    }
    public static Node recur(String s, int idx) {
        if(s==null || s.isBlank()) return null;
        if(idx>=s.length()) { return null; }
        StringBuilder num = new StringBuilder();
        while(idx<s.length() && s.charAt(idx)>='0' && s.charAt(idx)<='9') {
            num.append(s.charAt(idx));
            idx++;
        }
        Node root = new Node(Integer.parseInt(num.toString()));
        int count = 0;
        for(int i = idx; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                count++;
            }
            if(s.charAt(i)==')') {
                count--;
            }
            if(count == 0) {
                root.left = recur(s.substring(idx+1, i), 0);
                idx=i+1;
                break;
            }
        }
        count = 0;
        for(int i = idx; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                count++;
            }
            if(s.charAt(i)==')') {
                count--;
            }
            if(count == 0) {
                root.right = recur(s.substring(idx+1, i), 0);
                break;
            }
        }
        return root;
    }
}