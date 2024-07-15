package MinHeap_MaxHeap;

import java.util.*;

public class MaximumSumCombinations {

    public static void main(String[] args) {
        int[] A = { 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83 };
        int[] B = { 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83 };
        int c = 4;
        System.out.println(maxCombinations(A.length, c, A, B));
    }

    static List<Integer> maxCombinations(int N, int K, int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        PriorityQueue<SumPair> pq = new PriorityQueue<>(Comparator.comparing((SumPair a) -> a.sum).reversed());
        pq.add(new SumPair(num1[N-1]+num2[N-1], new Pair(N-1, N-1)));
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(N-1, N-1));
        List<Integer> ans = new ArrayList<>();
        while(K--!=0) {
            SumPair sumPair = pq.poll();
            assert sumPair != null;
            ans.add(sumPair.sum);
            Pair p = sumPair.p;
            if(p.a == 0 || p.b == 0) break;
            if(!set.contains(new Pair(p.a, p.b-1))) {
                pq.add(new SumPair(num1[p.a]+num2[p.b-1], new Pair(p.a, p.b-1)));
                set.add(new Pair(p.a, p.b-1));
            }
            if(!set.contains(new Pair(p.a-1, p.b))) {
                pq.add(new SumPair(num1[p.a-1] + num2[p.b], new Pair(p.a-1, p.b)));
                set.add(new Pair(p.a-1, p.b));
            }
            if(!set.contains(new Pair(p.a-1, p.b-1))) {
                pq.add(new SumPair(num1[p.a - 1] + num2[p.b - 1], new Pair(p.a - 1, p.b - 1)));
                set.add(new Pair(p.a-1, p.b-1));
            }
        }
        return ans;
    }

}

class Pair {
    int a;
    int b;
    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return a == pair.a && b == pair.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}

class SumPair {
    int sum;
    Pair p;
    SumPair(int sum, Pair p) {
        this.sum = sum;
        this.p = p;
    }
}
