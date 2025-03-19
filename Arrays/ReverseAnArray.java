package Arrays;

import java.util.Arrays;

public class ReverseAnArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ReverseAnArraySolution solution = new ReverseAnArraySolution();
        solution.reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }

}

class ReverseAnArraySolution {
    public void reverseArray(int arr[]) {
        int i = 0, j = arr.length-1;
        while(i<j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
