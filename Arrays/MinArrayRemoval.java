package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinArrayRemoval
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--!=0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i=0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(minElementRemoval(a, 0, n, 0, new HashMap<>()));
        }
    }
    public static int minElementRemoval(int[] nums, int idx, int n, int or, Map<String, Integer> map) {
        if(idx==n) {
            int i = 0;
            while((1<<i)<or) {
                i++;
            }
            if((1<<i)-1==or) {
                return 0;
            }
            return 300000;
        }
        String key = or+"-"+idx;
        if(map.containsKey(key)) return map.get(key);
        int ele = Math.min(minElementRemoval(nums, idx+1, n, or | nums[idx], map),
                (1+minElementRemoval(nums, idx+1, n, or, map)));
        map.put(key, ele);
        return ele;
    }
}
