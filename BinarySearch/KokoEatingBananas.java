package BinarySearch;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11}; int h = 8;
        KokoEatingBananasSolution solution = new KokoEatingBananasSolution();
        System.out.println(solution.minEatingSpeed(piles, h));
    }

}

class KokoEatingBananasSolution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0, sum = 0;
        for(int pile: piles) {
            high = Math.max(high, pile);
        }
        while(low<high) {
            int mid = (low + high) / 2;
            if(feasible(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean feasible(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile - 1) / speed + 1;
        }
        return time <= h;
    }
}