package Graphs.DisjointSet;

import java.util.Arrays;

public class UnionBySizeMain {
    public static void main(String[] args) {
        UnionBySize union = new UnionBySize(6);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        union.unionByRank(1,2);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        union.unionByRank(3,5);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        union.unionByRank(4,6);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,4));
        union.unionByRank(2,3);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,4));
        union.unionByRank(5,4);
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
        System.out.println(union.isConnected(1,5));
        System.out.println(union.isConnected(2,6));
        System.out.println(Arrays.toString(union.parent));
        System.out.println(Arrays.toString(union.size));
    }
}
class UnionBySize {
    int[] parent, size;
    public UnionBySize(int n) {
        size = new int[n+1];
        parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            size[i] = 1;
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
    public void unionByRank(int u, int v) {
        int ultimateParentU = findUltimateParent(u);
        int ultimateParentV = findUltimateParent(v);
        if(ultimateParentU == ultimateParentV) return;
        int sizeV = size[ultimateParentV];
        int sizeU = size[ultimateParentU];
        if(sizeV > sizeU) {
            parent[ultimateParentU] = ultimateParentV;
            size[ultimateParentV]+=size[ultimateParentU];
        } else if(sizeU > sizeV) {
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU]+=size[ultimateParentV];
        } else {
            parent[ultimateParentV] = ultimateParentU;
            size[ultimateParentU]+=size[ultimateParentV];
        }
    }
}
