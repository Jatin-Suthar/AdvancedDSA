package BinarySearch;

import java.util.Arrays;

public class AllocateBooks {

    public static void main(String[] args) {
        Solution_AllocateBooks solutionAllocateBooks = new Solution_AllocateBooks();
        int[] a = {12, 34, 67, 90};
        int b = 2;
        int ans = solutionAllocateBooks.books(a, b);
        System.out.println(ans);
    }

}

class Solution_AllocateBooks {
    public int books(int[] A, int B) {
        if(B>A.length) return -1;
        int low = 0, high = 0;
        for(int i: A) {
            high += i;
            low = Math.max(low, i);
        }

        while(low <= high) {
            int mid = (low + high)/2;
            int out = countStudents(A, mid);
            if(out > B) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return low;
    }

    private int countStudents(int[] a, int pages) {
        int student = 1;
        int pageCount = 0;
        for(int i=0; i<a.length; i++) {
            if(pageCount + a[i] <= pages) {
                pageCount += a[i];
            } else {
                student++;
                pageCount = a[i];
            }
        }
        return student;
    }
}
