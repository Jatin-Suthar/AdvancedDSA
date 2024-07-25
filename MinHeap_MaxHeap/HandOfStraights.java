package MinHeap_MaxHeap;

import java.util.*;

public class HandOfStraights {

    public static void main(String[] args) {
        int[] hand = {1,1,2,2,3,3};
        int groupSize = 2;
        HandOfStraightsSolution solution = new HandOfStraightsSolution();
        System.out.println(solution.isNStraightHand(hand, groupSize));
    }

}

class HandOfStraightsSolution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int card: hand) {
            map.put(card, map.getOrDefault(card, 0)+1);
        }
        Queue<FreqPair> pq = new PriorityQueue<>(Comparator.comparing(p -> p.val));
        for(int card: map.keySet()) pq.add(new FreqPair(card, map.get(card)));
        while(!pq.isEmpty()) {
            int t = groupSize;
            List<FreqPair> list = new ArrayList<>();
            int prev = -1;
            int min = Integer.MAX_VALUE;
            while(t--!=0) {
                if(pq.isEmpty()) return false;
                FreqPair p = pq.poll();
                if(prev!=-1 && prev+1 != p.val) { return false; }
                prev = p.val;
                min = Math.min(min, p.freq);
                list.add(p);
            }
            for(FreqPair p: list) {
                p.freq = p.freq-min;
                if(p.freq>0) {
                    pq.add(p);
                }
            }
        }
        return true;
    }
}

class FreqPair {
    int val;
    int freq;
    public FreqPair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}
/*
[1->1, 2->2, 3->2, 4->1, 6->1, 7->1, 8->1]
[1->1, 2->2, 3->2]
1
1->0, 2->1, 3->1
*/
