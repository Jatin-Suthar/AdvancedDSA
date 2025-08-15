package Trie;

import java.util.*;

public class DeleteDuplicateFolderInSystem {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("a"),List.of("c"),List.of("d"),List.of("a","b"),List.of("c","b"),List.of("d","a"));
        System.out.println(new Solution().deleteDuplicateFolder(new ArrayList<>(paths)));
    }
    static class Solution {
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            Node root = new Node("/");
            for (List<String> path : paths) {
                root.add(path);
            }

            Map<String, Node> seenStructures = new HashMap<>();
            serializeAndMark(root, seenStructures);
            buildResultPaths(root, new ArrayList<>());

            return ans;
        }

        private String serializeAndMark(Node curr, Map<String, Node> seenStructures) {
            if (curr.vert.isEmpty()) {
                return curr.val;
            }

            List<String> childSerializations = new ArrayList<>();
            for (Node child : curr.vert.values()) {
                childSerializations.add(serializeAndMark(child, seenStructures));
            }
            Collections.sort(childSerializations);

            StringBuilder subfolderKeyBuilder = new StringBuilder();
            for (String s : childSerializations) {
                subfolderKeyBuilder.append(s);
            }
            String subfolderKey = subfolderKeyBuilder.toString();

            if (seenStructures.containsKey(subfolderKey)) {
                seenStructures.get(subfolderKey).remove = true;
                curr.remove = true;
            } else {
                seenStructures.put(subfolderKey, curr);
            }

            return curr.val + "(" + subfolderKey + ")";
        }

        private void buildResultPaths(Node curr, List<String> currentPath) {
            if (curr.remove) {
                return;
            }

            if (!curr.val.equals("/")) {
                currentPath.add(curr.val);
                ans.add(new ArrayList<>(currentPath));
            }

            for (Node child : curr.vert.values()) {
                buildResultPaths(child, currentPath);
            }

            if (!curr.val.equals("/")) {
                currentPath.removeLast();
            }
        }
    }

    static class Node {
        String val;
        Map<String, Node> vert;
        boolean remove;

        public Node(String val) {
            this.val = val;
            this.vert = new TreeMap<>();
            this.remove = false;
        }

        public void add(List<String> path) {
            Node curr = this;
            for (String folder : path) {
                curr = curr.vert.computeIfAbsent(folder, Node::new);
            }
        }
    }
}
