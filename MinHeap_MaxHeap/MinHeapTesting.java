package MinHeap_MaxHeap;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinHeapTesting {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(20);
        minHeap.add(6);
        minHeap.add(8);
        minHeap.add(45);
        minHeap.add(90);
        minHeap.add(1);
        System.out.println(minHeap.peek());
        System.out.println(minHeap);


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(20);
        queue.add(6);
        queue.add(8);
        queue.add(45);
        queue.add(90);
        queue.add(1);
        queue.add(0);
        queue.poll();
        System.out.println(queue.peek());
        System.out.println(queue);

        List<Integer> list = new LinkedList<>();
        list.add(1);
        System.out.println(list);

        List<Integer> newList;
        Integer e;
        if((e = ((newList = list).get(0))) != null) {
            System.out.println(e);
            System.out.println(newList);
        }
    }

}
