package Strings;

public class SumOfBeautyOfAllStrings {

    public static void main(String[] args) {
        String s = "a";
        SumOfBeautyOfAllStringsSolution solution = new SumOfBeautyOfAllStringsSolution();
        System.out.println(solution.beautySum(s));
    }

}

class SumOfBeautyOfAllStringsSolution {
    public int beautySum(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                int[] freq = new int[26];
                for(int k=i; k<=j; k++) freq[arr[k]-'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    max = Math.max(max, freq[arr[j] - 'a']);
                    min = Math.min(min, freq[arr[j] - 'a']);
                }
                res += (max - min);
            }
        }
        return res;
    }
}
