package Greedy;

public class DecodedStringAtIndex {

    public static void main(String[] args) {
        String s = "a2345678999999999999999";
        Solution_DecodedStringAtIndex solution = new Solution_DecodedStringAtIndex();
        System.out.print(solution.decodeAtIndex(s, 10));
    }

}

class Solution_DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        long pivot = 0;
        int i = 0;
        while(pivot<k) {
            pivot = (Character.isDigit(s.charAt(i))) ? pivot * (s.charAt(i)-'0') : pivot+1;
            i++;
        }
        for(i--; i>0; i--) {
            if(Character.isDigit(s.charAt(i))) {
                pivot /= (s.charAt(i)-'0');
                k %= pivot;
            } else {
                if(k % pivot == 0) break;
                pivot--;
            }
        }

        return Character.toString(s.charAt(i));
    }
}