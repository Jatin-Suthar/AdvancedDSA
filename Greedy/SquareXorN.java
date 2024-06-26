package Greedy;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class SquareXorN {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            System.out.println(findX(l, r));
        }
    }

    public static int findX(int l, int r) {
        System.out.println(new Date().getTime());
        int count = 0;
        for (int n = l; n <= r; n++) {
            int i = 1;
            while (i * i <= n) {
                if ((i + 1) * (i + 1) > n && n % i == 0) {
                    count++;
                }
                i++;
            }
        }
        System.out.println(new Date().getTime());
        return count;
    }

}
