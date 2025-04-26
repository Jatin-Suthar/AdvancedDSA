package Heap_Queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class MinPairRemovalToSortTheArray {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        MinPairRemovalToSortTheArraySolution solution = new MinPairRemovalToSortTheArraySolution();
        System.out.println(solution.minimumPairRemoval(nums));
    }
}

class MinPairRemovalToSortTheArraySolution {
    public int minimumPairRemoval(int[] nums) {
        int minSteps = 0;
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int num: nums) linkedList.add(num);
        while(!isSortedAscending(linkedList)) {
            int min = Integer.MAX_VALUE, minIdx = -1;
            Iterator<Integer> it = linkedList.iterator();
            int prev = it.next();
            int idx = 1;
            while (it.hasNext()) {
                int curr = it.next();
                if (min > prev + curr) {
                    min = prev + curr;
                    minIdx = idx;
                }
                idx++;
                prev = curr;
            }
            minSteps++;
            linkedList.set(minIdx, min);
            linkedList.remove(minIdx-1);
        }
        return minSteps;
    }
    public boolean isSortedAscending(LinkedList<Integer> list) {
        if (list.size() <= 1) return true;

        Iterator<Integer> it = list.iterator();
        int prev = it.next();

        while (it.hasNext()) {
            int curr = it.next();
            if (curr < prev) return false;
            prev = curr;
        }

        return true;
    }
}

/*

5 2 3 1

[4->2]

*/
