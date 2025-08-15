package Tree;

import java.util.*;

public class MinimalScoreAfterRemovalFromTree {
    public static void main(String[] args) {
        int[] nums = {1,5,5,4,11}; int[][] edges = {{0,1},{1,2},{1,3},{3,4}};
        System.out.println(new Solution().minimumScore(nums, edges));
    }
    static class Solution {
        int[] xorSubtree, in, out;
        int time = 0;
        int totalXor;
        List<Integer>[] graph;

        public int minimumScore(int[] nums, int[][] edges) {
            int n = nums.length;
            graph = new ArrayList[n];
            for (int i = 0; i < n; ++i) graph[i] = new ArrayList<>();
            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }

            xorSubtree = new int[n];
            in = new int[n];
            out = new int[n];
            dfs(0, -1, nums);
            totalXor = xorSubtree[0];

            int res = Integer.MAX_VALUE;

            for (int i = 1; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    int a = i, b = j;

                    if (isAncestor(a, b)) {
                        int x = xorSubtree[b];
                        int y = xorSubtree[a] ^ xorSubtree[b];
                        int z = totalXor ^ xorSubtree[a];
                        res = Math.min(res, getScore(x, y, z));
                    } else if (isAncestor(b, a)) {
                        int x = xorSubtree[a];
                        int y = xorSubtree[b] ^ xorSubtree[a];
                        int z = totalXor ^ xorSubtree[b];
                        res = Math.min(res, getScore(x, y, z));
                    } else {
                        int x = xorSubtree[a];
                        int y = xorSubtree[b];
                        int z = totalXor ^ x ^ y;
                        res = Math.min(res, getScore(x, y, z));
                    }
                }
            }
            return res;
        }

        void dfs(int u, int parent, int[] nums) {
            in[u] = ++time;
            xorSubtree[u] = nums[u];
            for (int v : graph[u]) {
                if (v == parent) continue;
                dfs(v, u, nums);
                xorSubtree[u] ^= xorSubtree[v];
            }
            out[u] = ++time;
        }

        boolean isAncestor(int u, int v) {
            return in[u] <= in[v] && out[v] <= out[u];
        }

        int getScore(int a, int b, int c) {
            int max = Math.max(a, Math.max(b, c));
            int min = Math.min(a, Math.min(b, c));
            return max - min;
        }
    }
}
