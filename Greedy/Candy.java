package Greedy;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {100, 80, 70, 60, 70, 80, 90, 100, 90, 80, 70, 60, 60};
        System.out.println(new Solution().candy(ratings));
    }
    static class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int candy = 1, smaller = 0, sum = 1;
            for(int i=1; i<n; i++){
                // rating is smaller
                if(ratings[i] < ratings[i-1]) {
                    if(candy > 1) smaller--;
                    sum+=(++smaller + 1);
                    candy=1;
                }
                // rating is bigger or equal
                else {
                    smaller = 0;
                    if(ratings[i]==ratings[i-1]) {
                        sum++;
                    } else {
                        candy++;
                        sum += candy;
                    }
                }
            }
            return sum;
        }
    }
}
