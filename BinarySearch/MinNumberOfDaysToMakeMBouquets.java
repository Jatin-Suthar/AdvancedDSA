package BinarySearch;

public class MinNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2}; int m = 3, k = 1;
        MinNumberOfDaysToMakeMBouquetsSolution solution = new MinNumberOfDaysToMakeMBouquetsSolution();
        System.out.println(solution.minDays(bloomDay, m, k));
    }
}

class MinNumberOfDaysToMakeMBouquetsSolution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k > n) return -1;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for(int flower: bloomDay) {
            l = Math.min(l, flower);
            r = Math.max(r, flower);
        }
        while(l<r) {
            int mid = l+((r-l)/2);
            if(feasible(bloomDay, mid, m, k)) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    public boolean feasible(int[] bloomDay, int minDay, int m, int k) {
        int count = 0, bouquet = 0;
        for(int day: bloomDay) {
            if(day<=minDay) {
                count++;
            } else {
                bouquet += (count/k);
                count=0;
            }
        }
        bouquet += (count/k);
        return bouquet>=m;
    }
}