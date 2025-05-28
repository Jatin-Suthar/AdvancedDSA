package BinarySearch;

public class H_Index {
    public static void main(String[] args) {
        int[] citations = {1,2,4,5,8,10};
        H_IndexSolution solution = new H_IndexSolution();
        System.out.println(solution.hIndex(citations));
    }
}

class H_IndexSolution {
    public int hIndex(int[] citations) {
        int n, ans = 0;
        int st = 0, ed = (n = citations.length)-1, mid = (st+ed) >> 1;
        while(st <= ed) {
            int paper = n-mid;
            if(citations[mid] >= paper) {
                ans = paper;
                ed = mid-1;
            } else {
                st = mid+1;
            }
            mid = (st+ed) >> 1;
        }
        return ans;
    }
}
/*
0 1 2 3 4 5
1 2 4 5 8 10
s   m     e

max(h)
atleast(h) papers : x >= h
been cited atleast(h) times: citations[x] >= h

*/