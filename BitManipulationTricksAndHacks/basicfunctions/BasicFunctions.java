package BitManipulationTricksAndHacks.basicfunctions;

public class BasicFunctions {
    public static void main(String[] args) {
        int num = 15;
        System.out.println(convertCharToLower('K'));
    }
    public static String convertToBinaryString(int num) {
        StringBuilder sBinary = new StringBuilder();
        for(int i=10; i>=0; i--) {
            sBinary.append((num >> i) & 1);
        }
        return sBinary.toString();
    }
    public static boolean ithBitIsSetOrNot(int num, int i) {
        return (num&(1<<i)) != 0;
    }
    public static int countSetBits(int num) {
        int count = 0;
        while(num>0) {
            if(num%2!=0) count++;
            num = num >> 1;
        }
        return count;
    }
    public static int countSetSignedBits(int num) {
        int count = 0;
        for(int i=31; i>=0; i--) {
            if((num & (1<<i)) != 0) count++;
        }
        return count;
    }
    public static boolean checkWhetherNumIsPowerOfTwo(int num) {
        return (num!=0 && (num & (num-1)) == 0);
    }
    public static long nextPowerOfTwo(long n) {
        if (n == 0) return 1;
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n |= n >> 32;
        return n + 1;
    }
    public static char convertCharToLower(char c) {
        return (char) (c | (1 << 5));
    }
    public static char convertCharToUpper(char c) {
        return (char) (c & ~(1 << 5));
    }
    public static int findPosiOfChar(char c) {
        return (c & 31);
    }
}
/*
#############################################
convert chars to lower case and upper case:

1001011 : 75 : K
0100000 : 32
1101011 : 75+32 : 107 : k
#############################################
find position of character:

1001011 : 75 : 'K'
0011111
0001011 : 11 posi

1100001 : 97 : 'a'
0011111
0000001 : 1  posi
#############################################
Swap with XOR:

  a=4;
  b=5;
  a=a^b;
  b=b^a;
  a=a^b;

100 : a
101 : b
------- a : 001

001 : a
101 : b
------- b : 100

001 : a
100 : b
------- a : 101
#############################################
 */
