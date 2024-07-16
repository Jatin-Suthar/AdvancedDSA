package MinHeap_MaxHeap;

import java.util.*;

public class FindMedianOfDataStream {
}

class MedianFinder {
    Queue<Integer> largeHeap;
    Queue<Integer> smallHeap;
    public MedianFinder() {
        largeHeap = new PriorityQueue<>(Collections.reverseOrder());
        smallHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        largeHeap.add(num);
        if(largeHeap.size() > smallHeap.size()+1) {
            smallHeap.add(largeHeap.poll());
        }
        if(!largeHeap.isEmpty() && !smallHeap.isEmpty() && largeHeap.peek()>smallHeap.peek()) {
            smallHeap.add(largeHeap.poll());
        }
        if(smallHeap.size() > largeHeap.size()+1) {
            largeHeap.add(smallHeap.poll());
        }
    }

    public double findMedian() {
        if((largeHeap.size()+smallHeap.size())%2==0) {
            return ((double) largeHeap.peek() + (double) smallHeap.peek())/2;
        }
        return (largeHeap.size()>smallHeap.size()?largeHeap.peek():smallHeap.peek());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */