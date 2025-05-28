package BitManipulation;

public class ClearingSetBitsUpToIthBit {
    public static void main(String[] args) {
        int a = 59, i = 4;
        int b=(a&(-(1 << (i + 1))));
        System.out.println(b);
    }
}