package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) { set.add(num); }
        int maxStreak=0;
        for(int num: nums) {
            if(!set.contains(num-1)) {
                int currStreak=1;
                int currNum = num;
                while(set.contains(currNum+1)) {
                    currStreak++;
                    currNum+=1;
                }
                maxStreak=Math.max(currStreak, maxStreak);
            }
        }
        return maxStreak;
    }

}
