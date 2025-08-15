package Trie;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        String[] folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(new Solution().removeSubfolders(folder));
    }
    static class Solution {
        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder, Comparator.comparing(String::length));
            List<String> ans = new ArrayList<>();
            Node root = new Node();
            for(String dir: folder) {
                if(root.valid(dir)) {
                    root.add(dir);
                    ans.add(dir);
                }
            }
            return ans;
        }
    }
}

class Node {
    Map<String, Node> vert;
    boolean isEnd;
    public Node() {
        this.vert = new HashMap<>();
        isEnd = false;
    }
    public boolean valid(String folder) {
        Node curr = this;
        String[] names = folder.split("/");
        for(int i=1; i<names.length; i++) {
            Node next = curr.vert.get(names[i]);
            if(next!=null) {
                if(next.isEnd) return false;
                curr = next;
            } else {
                return true;
            }
        }
        return true;
    }
    public void add(String folder) {
        Node curr = this;
        String[] names = folder.split("/");
        for(int i=1; i<names.length; i++) {
            Map<String, Node> neighbour = curr.vert;
            if(!neighbour.containsKey(names[i])) {
                neighbour.put(names[i], new Node());
            }
            curr = curr.vert.get(names[i]);
        }
        curr.isEnd = true;
    }
}
