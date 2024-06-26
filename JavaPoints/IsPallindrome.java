package JavaPoints;

public class IsPallindrome {

    public static void main(String[] args) {
        String str = "aacab";
        int freq[] = new int[26];
        for(char c: str.toCharArray()) {
            freq[c-'a']++;
        }
        int count = 0;
        for(int i: freq) {
            if(!(i%2==0)) {
                count++;
            }
        }
        System.out.println("Is Pallindrome: " + (count==1));
    }

}
