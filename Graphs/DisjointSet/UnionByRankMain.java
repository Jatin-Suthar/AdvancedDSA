package Graphs.DisjointSet;

public class UnionByRankMain {
    public static void main(String[] args) {
        UnionByRank union = new UnionByRank(6);
        union.unionByRank(1,2);
        union.unionByRank(3,5);
        union.unionByRank(4,6);
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,4));
        union.unionByRank(2,3);
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,4));
        union.unionByRank(5,4);
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,4));
    }
}
class UnionByRank {
    int[] parent, rank;
    public UnionByRank(int n) {
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
    }
    public boolean isConnected(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }
    public int findUltimateParent(int v) {
        if(v==parent[v]) return v;
        return parent[v] = findUltimateParent(parent[v]);
    }
    public void unionByRank(int v, int u) {
        int ultimateParentV = findUltimateParent(v);
        int ultimateParentU = findUltimateParent(u);
        if(ultimateParentU == ultimateParentV) return;
        int rankV = rank[ultimateParentV];
        int rankU = rank[ultimateParentU];
        if(rankV > rankU) {
            parent[ultimateParentU] = ultimateParentV;
        } else if(rankU > rankV) {
            parent[ultimateParentV] = ultimateParentU;
        } else {
            parent[ultimateParentV] = ultimateParentU;
            rank[u]++;
        }
    }
}
