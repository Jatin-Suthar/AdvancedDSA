public class ConstructKPalindromeStrings {

    public static void main(String[] args) {
        String s = "cxayrgpcctwlfupgzirmazszgfiusitvzsnngmivctprcotcuutfxdpbrdlqukhxkrmpwqqwdxxrptaftpnilfzcmknqljgbfkzuhksxzplpoozablefndimqnffrqfwgaixsovmmilicjwhppikryerkdidupvzdmoejzczkbdpfqkgpbxcrxphhnxfazovxbvaxyxhgqxcxirjsryqxtreptusvupsstylpjniezyfokbowpbgxbtsemzsvqzkbrhkvzyogkuztgfmrprz";
        int k = 5;
        ConstructKPalindromeStringSolution solution = new ConstructKPalindromeStringSolution();
        System.out.println(solution.canConstruct(s, k));
    }

}

class ConstructKPalindromeStringSolution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        int[] freqArr = new int[26];
        for(char c: s.toCharArray()) {
            freqArr[c-'a']++;
        }
        int noOfOnes = 0;
        for(int freq: freqArr) {
            noOfOnes += ((freq%2)==1) ? 1 : 0;
        }
        return noOfOnes <= k;
    }
}