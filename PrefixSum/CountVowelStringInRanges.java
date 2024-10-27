package PrefixSum;

import java.util.Arrays;

public class CountVowelStringInRanges {

    public static void main(String[] args) {
        String[] words = {"b","rmivyakd","kddwnexxssssnvrske","vceguisunlxtldqenxiyfupvnsxdubcnaucpoi","nzwdiataxfkbikbtsjvcbjxtr","wlelgybcaakrxiutsmwnkuyanvcjczenuyaiy","eueryyiayq","bghegfwmwdoayakuzavnaucpur","ukorsxjfkdojcxgjxgmxbghno","pmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhl","gsjdpelkbsruooeffnvjwtsidzw","ugeqzndjtogxjkmhkkczdpqzwcu","ppngtecadjsirj","rvfeoxunxaqezkrlr","adkxoxycpinlmcvmq","gfjhpxlzmokcmvhjcrbrpfakspscmju","rgmzhaj","ychktzwdhfuruhpvdjwfsqjhztshcxdey","yifrzmmyzvfk","mircixfzzobcficujgbj","d","pxcmwnqknyfkmafzbyajjildngccadudfziknos","dxmlikjoivggmyasaktllgmfhqpyznc","yqdbiiqexkemebyuitve"};
        int[][] queries = {{5, 21},{17, 22},{19, 23},{13, 15},{20, 23},{21, 23},{6, 20},{1, 8},{15, 20},{17, 22},{6, 6},{1, 2},{4, 11},{14, 23},{7, 10},{16, 22},{20, 22},{21, 22},{15, 18},{5, 16},{17, 23}};
        CountVowelStringInRangesSolution solution = new CountVowelStringInRangesSolution();
        System.out.println(Arrays.toString(solution.vowelStrings(words, queries)));
    }

}

class CountVowelStringInRangesSolution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pSum = new int[words.length+1];
        pSum[0]=0;
        int[] res = new int[queries.length];
        for(int i=0; i<words.length; i++) {
            pSum[i+1] = pSum[i]+isRightStr(words[i]);
        }
        int k=0;
        for(int[] query: queries) {
            int l = query[0], r = query[1];
            res[k++] = pSum[r+1]-pSum[l];
        }
        return res;
    }
    public int isRightStr(String word) {
        int n = word.length();
        if(n == 0) return 1;
        if(isVowel(word.charAt(0)) && isVowel(word.charAt(n-1))) return 1;
        return 0;
    }
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
// [aba,bcb,ece,aa,e]
// [1,1,2,3,4]
// [2,3,0]