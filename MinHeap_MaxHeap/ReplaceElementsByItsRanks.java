package MinHeap_MaxHeap;

import java.util.*;

public class ReplaceElementsByItsRanks {

    public static void main(String[] args) {

        int[] arr = {20, 2, 2, 2, 98, 6};
        System.out.println(Arrays.toString(replaceWithRank(arr, arr.length)));

    }

    static int[] replaceWithRank(int[] arr, int N) {
        Queue<RankPair> pq = new PriorityQueue<>(Comparator.comparing(p -> p.val));
        for(int i=0; i<N; i++) {
            pq.add(new RankPair(arr[i], i));
        }
        int[] res = new int[N];
        int k=0, prev = -1;
        while(!pq.isEmpty()) {
            RankPair p = pq.poll();
            int idx = p.idx;
            if(prev!=-1 && arr[prev]==arr[idx]) {
                res[idx] = k;
            } else {
                res[idx] = k+++1;
            }
            prev = idx;
        }
        return res;
    }

}

class RankPair {
    int val;
    int idx;
    public RankPair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}