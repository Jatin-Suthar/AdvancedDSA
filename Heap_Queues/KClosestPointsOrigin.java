package Heap_Queues;

import java.util.*;

public class KClosestPointsOrigin {

    public static void main(String[] args) {
        int[][] input = {{3,3},{5,-1},{-2,4}};
//        int[][] input = {{1,3},{-2,2}};
        Solution_KClosestPointsOrigin sl = new Solution_KClosestPointsOrigin();
        int[][] res = sl.kClosest(input, 1);
        for(int point[]: res) {
            System.out.println(Arrays.toString(point));
        }
    }

}

class Solution_KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int k) {

        Comparator<Helper> lengthComparator = new Comparator<Helper>() {
            @Override
            public int compare(Helper o1, Helper o2) {
                return Double.compare(o1.distance, o2.distance);
            }
        };

        PriorityQueue<Helper> pq = new PriorityQueue<>(lengthComparator);

        for(int[] point: points) {
            pq.add(new Helper(point, Math.pow((Math.pow(point[0], 2)) + (Math.pow(point[1], 2)), 0.5)));
        }

        int[][] res = new int[k][2];
        int i=0;
        while(i<k) {
            res[i++] = pq.poll().point;
        }
        return res;
    }
}

class Helper {
    int[] point;
    double distance;

    public Helper(int[] point, double distance) {
        this.point = point;
        this.distance = distance;
    }
}