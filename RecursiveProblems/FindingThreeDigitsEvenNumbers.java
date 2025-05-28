package RecursiveProblems;

import java.util.*;

public class FindingThreeDigitsEvenNumbers {
    public static void main(String[] args) {
        int[] digits = {2,1,3,0};
        FindingThreeDigitsEvenNumbersSolution solution = new FindingThreeDigitsEvenNumbersSolution();
        System.out.println(Arrays.toString(solution.findEvenNumbers(digits)));
    }
}

class FindingThreeDigitsEvenNumbersSolution {
    Set<Integer> set = new TreeSet<>();
    public int[] findEvenNumbers(int[] digits) {
        recur(digits, new boolean[digits.length], 0);
        int[] res = new int[set.size()];
        int k=0;
        for(int num: set) {
            res[k++] = num;
        }
        return res;
    }
    public void recur(int[] digits, boolean[] visited, int num) {
        if(getLength(num) == 3) {
            if(num%2 == 0) {
                set.add(num);
            }
            return;
        }
        for(int i=0; i<digits.length; i++) {
            if(!visited[i] && !(num == 0 && digits[i] == 0)) {
                visited[i] = true;
                recur(digits, visited, (num*10 + digits[i]));
                visited[i] = false;
            }
        }
    }
    public int getLength(int num) {
        if (num == 0) return 1;
        return (int) Math.floor(Math.log10(num)) + 1;
    }
}