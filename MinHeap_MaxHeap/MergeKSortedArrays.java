package MinHeap_MaxHeap;

import java.util.*;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        while (t-- > 0) {
            int k = sc.nextInt();
            while (k-- != 0) {
                int n = sc.nextInt();
                ArrayList<Integer> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++) {
                    list.add(sc.nextInt());
                }
                a.add(list);
            }
        }
        System.out.println(a);
        System.out.println(mergeKSortedArrays(a, a.size()));
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        Queue<IdxPair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.a));
        for(int i=0; i<kArrays.size(); i++) {
            queue.add(new IdxPair(kArrays.get(i).get(0), i, 0));
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            IdxPair pair = queue.poll();
            res.add(pair.a);
            int i = pair.b;
            int j = pair.c;
            if(j+1 < kArrays.get(i).size()) {
                queue.add(new IdxPair(kArrays.get(i).get(j+1), i, j+1));
            }
        }
        return res;
    }
}

class IdxPair {
    int a;
    int b;
    int c;
    public IdxPair(int a, int b, int c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
