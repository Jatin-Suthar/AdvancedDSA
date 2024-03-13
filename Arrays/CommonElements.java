package Arrays;

import java.util.*;

public class CommonElements {

    public static void main(String[] args) {
        System.out.println(commonElements(new int[] {1, 3}, new int[] {1}, new int[] {1, 3, 6, 7}, 2, 1, 4));
    }

    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        List<Integer> list1 = Arrays.stream(A).boxed().toList();
        List<Integer> list2 = Arrays.stream(B).boxed().toList();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i: C) {
            if(list1.contains(i) && list2.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }

}
