package PrefixSum;

public class NoOfSubArrayWithOddSum {

    public static void main(String[] args) {
        int[] nums = {100,100,99,99};
        NoOfSubArrayWithOddSumSolution solution = new NoOfSubArrayWithOddSumSolution();
        System.out.println(solution.numOfSubarrays(nums));
    }

}

class NoOfSubArrayWithOddSumSolution {
    int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int even = (arr[0]%2==0) ? 1 : 0, odd = (arr[0]%2==0) ? 0 : 1;
        int ans = odd, sum = arr[0];
        for(int i=1; i<arr.length; i++) {
            sum += arr[i];
            if(sum%2!=0) {
                ans = (ans + (1+even))%MOD;
                odd++;
            } else {
                ans = (ans + odd)%MOD;
                even++;
            }
        }
        return ans;
    }
}
/*

[100,100,99,99]
[100,200,299]

*/
/*

[100,100,99,99]
[100,200,299]

*/