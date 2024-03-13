package Arrays;

public class ShiningStarsFashion {

    public static void main(String[] args) {
        int stopAt = 3;
        boolean isSouthEast = true;
        int n = 4;
        recur(n, isSouthEast, stopAt);
    }

    public static void recur(int n, boolean isSouthEast, int stopAt) {
        if(n==0) { return; }
        int iter = stopAt;
        if(isSouthEast) {
            int space = 0;
            while(iter--!=0) {
                System.out.print("|");
                int gap = space;
                while(gap--!=0) {
                    System.out.print(" ");
                }
                System.out.print("*");
                space++;
                System.out.println();
            }
            System.out.println("|    *");
        } else {
            int space = stopAt-1;
            while(iter--!=0) {
                System.out.print("|");
                int gap = space;
                while(gap--!=0) {
                    System.out.print(" ");
                }
                System.out.print("*");
                space--;
                System.out.println();
            }
        }
        recur(--n, !isSouthEast, stopAt);
    }

}
