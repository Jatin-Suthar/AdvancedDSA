package DynamicProgrammingPatterns.Strings;

import java.util.*;

public class LongestUnequalAdjacentGroupSubsequenceII {
    public static void main(String[] args) {
        String[] words = {"abcd","abc","bbdd","accd","acce"}; int[] groups = {1,2,3,4,5};
        Solution solution = new Solution();
        System.out.println(solution.getWordsInLongestSubsequence(words, groups));
    }
    static class Solution {
        public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
            int n=words.length, maxDp=1, maxDpIdx=0;
            int[] dp=new int[n];
            int[] prev=new int[n];
            for(int i=0;i<n;i++){
                dp[i]=1;
                prev[i]=i;
                for(int j=i-1;j>=0;j--){
                    if(dp[j]+1>dp[i] && groups[i]!=groups[j] && canConnect(words[i],words[j])){
                        dp[i]=dp[j]+1;
                        prev[i]=j;
                    }
                }
                if(dp[i]>maxDp){
                    maxDp=dp[i];
                    maxDpIdx=i;
                }
            }
            List<String> res=new ArrayList<>();
            while(maxDpIdx!=prev[maxDpIdx]){
                res.add(words[maxDpIdx]);
                maxDpIdx=prev[maxDpIdx];
            }
            res.add(words[maxDpIdx]);
            return res.reversed();
        }
        private boolean canConnect(String a, String b){
            if(a.length()!=b.length()){
                return false;
            }
            int cnt=0;
            for(int i=0;i<a.length();i++){
                if(a.charAt(i)!=b.charAt(i)){
                    cnt++;
                    if(cnt>1){
                        return false;
                    }
                }
            }
            return cnt==1;
        }
    }
}
