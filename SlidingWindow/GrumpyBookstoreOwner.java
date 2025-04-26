package SlidingWindow;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customer = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        GrumpyBookstoreOwnerSolution solution = new GrumpyBookstoreOwnerSolution();
        System.out.println(solution.maxSatisfied(customer, grumpy, minutes));
    }
}

class GrumpyBookstoreOwnerSolution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0, n = customers.length;
        for(int i=0; i<n; i++) {
            if(grumpy[i] == 0) satisfied += customers[i];
        }
        int currSum = 0;
        for(int i=0; i<minutes; i++) {
            if(grumpy[i] == 1) currSum += customers[i];
        }
        int ans = currSum;
        for(int i=minutes; i<n; i++) {
            if(grumpy[i] == 1) {
                currSum += customers[i];
            }
            if(grumpy[i-minutes]==1) {
                currSum -= customers[i-minutes];
            }
            ans = Math.max(ans, currSum);
        }
        return ans + satisfied;
    }
}
/*
customers = [1,0,1,2,1,1,7,5],
   grumpy = [0,1,0,1,0,1,0,1],
   minutes = 3
[1,0,1,2,1,1,7,5]
[0,1,0,1,0,1,0,1]
[1, 1,2,2,3,3,10,10] : left
[10,9,9,8,8,7,7, 0]  : right
 0  1 2 3 4 5 6  7
 0
 */