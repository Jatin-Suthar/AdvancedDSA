package BitManipulation;

public class HammingDistance {
    public int findHammingDistanceBetweenTwoStrings(String s, String t) {
        if((s.length()^t.length()) != 0) return -1;
        int unequal = 0;
        for(int i=0; i<s.length(); i++) {
            if((s.charAt(i)^t.charAt(i)) != 0) {
                unequal++;
            }
        }
        return unequal;
    }
    public int findHammingDistanceBetweenTwoInteger(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while(xor != 0) {
            xor &= (xor-1);
            count++;
        }
        return count;
    }
}
