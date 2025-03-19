package Maths;

import java.util.Scanner;

public class CheckArmstrong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (n==0) ? 1 : (int) (Math.log10(n) + 1);
        int num = n, sum = 0;
        while(num>0) {
            sum += (int) Math.pow((num%10), len);
            num /= 10;
        }
        System.out.println(sum == n);
    }

}
