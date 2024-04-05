package Tree;

import java.util.HashMap;

import static Tree.Solution_CheckMirrorInNthTree.checkMirrorTree;
import java.util.*;

public class CheckMirrorInNthTree {

    public static void main(String[] args) {
        int n = 3, e = 2;
        int first[] = {1,3,1,2};
        int second[] = {1,2,1,3};
        System.out.println(checkMirrorTree(n, e, first, second));

        Map<Integer, Integer> map = new HashMap<>();
    }

}

class Solution_CheckMirrorInNthTree {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        if(A.length!=B.length) return 0;
        int size = 0;
        int times = 1;
        int start = 0;
        while(start<A.length) {
            size = size+(((int) Math.pow(e, times))*2);
            int i1 = start, i2 = start+1;
            int j1 = size-1, j2 = size-2;
            while(j2>=start) {
                if(A[i1]!=B[j2] || A[i2]!=B[j1]) {
                    return 0;
                }
                j2-=2;
                j1-=2;
                i1+=2;
                i2+=2;
            }
            start += size;
            times += 1;
        }
        return 1;
    }
}

//3*2
//3*3*2
