package Trie;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordBreak {

    class Solution {
        class Node {
            Node[] links = new Node[26];
            boolean flag;

            public boolean contains(char c) { return links[c-'a']!=null; }

            public Node get(char c) { return links[c-'a']; }

            public boolean isEnd() { return flag; }

            public void put(char c, Node node) {
                links[c-'a'] = node;
            }

            public void setEnd() {
                flag = true;
            }
        }
        public boolean wordBreak(String s, List<String> wordDict) {
            Node root = new Node();
            for(String word: wordDict) {
                addNode(word, root);
            }
            return helper(s.toCharArray(), 0, root);
        }
        public boolean helper(char a[], int idx, Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            boolean[] vis = new boolean[a.length];
            while(!q.isEmpty() && idx<a.length) {
                int size = q.size();
                for(int i=0; i<size; i++) {
                    Node node = q.poll();
                    if(node.contains(a[idx])) {
                        q.add(node.get(a[idx]));
                        if(node.links[a[idx]-'a'].flag && !vis[idx]) {
                            q.add(root);
                            vis[idx]=true;
                        }
                    }
                }
                if(!q.isEmpty()) idx++;
            }
            return (idx==a.length) && vis[a.length-1];
        }
        public void addNode(String str, Node root) {
            Node node = root;
            for(char c: str.toCharArray()) {
                if(!node.contains(c)) {
                    node.put(c, new Node());
                }
                node = node.get(c);
            }
            node.flag = true;
        }
    }

}
