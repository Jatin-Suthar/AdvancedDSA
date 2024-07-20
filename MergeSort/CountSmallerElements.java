package MergeSort;

import java.util.*;

public class CountSmallerElements {

    public static void main(String[] args) {
        int[] arr = {12, 1, 2, 3, 0, 11, 4};
        CountSmallerElementsSolution solution = new CountSmallerElementsSolution();
        System.out.println(Arrays.toString(solution.constructLowerArray(arr)));
    }

}

class CountSmallerElementsSolution {
    int[] constructLowerArray(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        ArrayElementInfo[] cpy = new ArrayElementInfo[length];
        for(int i = 0; i < length; i++) {
            cpy[i] = new ArrayElementInfo(arr[i], i);
        }
        divide(cpy, result, 0, length-1);
        return result;
    }
    void divide(ArrayElementInfo[] arr, int[] result, int s, int e) {
        if(s<e) {
            int m = (s+e)/2;
            divide(arr, result, s, m);
            divide(arr, result, m+1, e);
            merge(arr, result, s, e, m);
        }
    }
    void merge(ArrayElementInfo[] arr, int[] result, int s, int e, int m) {
        int i=s;
        int j=m+1;
        List<ArrayElementInfo> list = new LinkedList<>();
        int smallerElements = 0;
        while(i<=m && j<=e) {
            if(arr[i].val<arr[j].val) {
                result[arr[i].pos] += smallerElements;
                list.add(arr[i++]);
            } else {
                smallerElements++;
                list.add(arr[j++]);
            }
        }
        while(i<=m) {
            result[arr[i].pos] += smallerElements;
            list.add(arr[i++]);
        }
        while(j<=e) {
            result[arr[i].pos] += smallerElements;
            list.add(arr[j++]);
        }
        int k=0;
        while((s+k)<=e) {
            arr[s+k]=list.get(k);
            k++;
        }
    }
}

class ArrayElementInfo {
    int val;
    int pos;
    public ArrayElementInfo(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}