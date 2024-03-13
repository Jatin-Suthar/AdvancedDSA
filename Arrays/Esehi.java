package Arrays;

public class Esehi {

    public static void main(String args[]) {
        int x=4;
        boolean inc = true;
        int space = 0;
        while(x--!=0) {
            int iter = 3;
            if(inc) {
                while(iter--!=0) {
                    System.out.print("|");
                    int times = space++;
                    while(times--!=0) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                }
                inc = false;
            } else {
                while(iter--!=0) {
                    System.out.print("|");
                    int times = space--;
                    while(times--!=0) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    System.out.println();
                }
                inc = true;
            }
        }
    }

}
