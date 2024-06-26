package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class KArraysSorting {

    public static void main(String[] args) {
        List<int[]> list = List.of(new int[] {1,6,7,13}, new int[]{6,34,56,57}, new int[]{44,49,56,78,90});
        System.out.println(Arrays.toString(
                kSort(list)
        ));
    }

    public static int[] kSort(List<int[]> list) {
        int[] indexes = new int[list.size()];
        int size = list.stream().mapToInt(Array::getLength).sum();
        int k = 0;
        int res[] = new int[size];
        while(k<res.length) {
            int min = Integer.MAX_VALUE;
            int putIdx = -1;
            for(int idx = 0; idx<indexes.length; idx++) {
                if(indexes[idx]<list.get(idx).length && min>list.get(idx)[indexes[idx]]) {
                    putIdx = idx;
                    min = list.get(idx)[indexes[idx]];
                }
            }
            if(putIdx!=-1) {
                res[k++] = min;
                indexes[putIdx]++;
            }
        }
        return res;
    }

}
