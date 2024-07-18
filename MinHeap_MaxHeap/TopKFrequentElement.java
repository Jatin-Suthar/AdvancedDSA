package MinHeap_MaxHeap;

import java.util.*;

public class TopKFrequentElement {



}

class FrequentSolution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0)+1);
        Queue<FrequencyPair> pq = new PriorityQueue<>(Comparator.comparing((FrequencyPair p) -> p.frequency).reversed());
        for(int key: map.keySet()) {
            pq.add(new FrequencyPair(map.get(key), key));
        }
        int[] res = new int[k];
        int idx = 0;
        while(k--!=0) {
            res[idx++] = pq.poll().val;
        }
        return res;
    }
}

class FrequencyPair {
    int frequency;
    int val;
    public FrequencyPair(int freq, int val) {
        this.frequency = freq;
        this.val = val;
    }
}