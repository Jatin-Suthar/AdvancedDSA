package Intuitive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MakeLexicographicallySmallestArray {

    public static void main(String[] args) {
        int[] nums = {1,5,3,9,8};
        int diff = 2;
        MakeLexicographicallySmallestArraySolution solution = new MakeLexicographicallySmallestArraySolution();
        System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums, diff)));
    }

}

class MakeLexicographicallySmallestArraySolution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for(int i=0; i<n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.val));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(pairs[0].idx);
        int i=0, j=1;
        while(i<n && j<n) {
            if(pairs[j].val - pairs[j-1].val > limit) {
                while(!queue.isEmpty()) {
                    nums[queue.poll()] = pairs[i].val;
                    i++;
                }
            }
            queue.add(pairs[j].idx);
            j++;
        }
        while(!queue.isEmpty()) {
            nums[queue.poll()] = pairs[i].val;
            i++;
        }
        return nums;
    }
}
class Pair {
    int val;
    int idx;
    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
/*

[1,5,3,2] 2
[1,3,5,2]
[1,2,5,3]
[1,2,3,5]

*/