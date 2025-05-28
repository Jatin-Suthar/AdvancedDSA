package Heap_Queues;

import java.util.*;

public class MaximumProductOfTwoDigits {
    public int maxProduct(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(n>0) {
            int rem = n%10;
            if(queue.size() == 2) {
                if(queue.peek()<rem) {
                    queue.poll();
                    queue.add(rem);
                }
            } else {
                queue.add(rem);
            }
            n /= 10;
        }
        if(queue.size()<2) return -1;
        return queue.poll()*queue.poll();
    }
}