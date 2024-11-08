package PrefixSum;

public class CheckIfArrayPairsAreDivisibleByK {

    public static void main(String[] args) {
        int[] arr = {4,-2,2,6};
        int k = 1;
        CheckIfArrayPairsAreDivisibleByKSolution solution
                = new CheckIfArrayPairsAreDivisibleByKSolution();
        System.out.println(solution.canArrange(arr, k));
    }

}

class CheckIfArrayPairsAreDivisibleByKSolution {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k+1];
        for(int num: arr) {
            freq[((num%k)+k)%k]++;
        }
        if(freq[0]%2!=0) return false;
        int s=1, e=k-1;
        while(s<=e) {
            if(freq[s++]!=freq[e--]) return false;
        }
        return true;
    }
}