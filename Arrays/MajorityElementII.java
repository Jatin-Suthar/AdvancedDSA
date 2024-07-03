package Arrays;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

1. Example:
   Input: nums = [3,2,3]
   Output: 3

2. Example:
   Input: nums = [2,2,1,1,1,2,2]
   Output: 2
 */

public class MajorityElementII {

    public int majorityElement(int[] nums) {
        int count = 0, maj = 0;
        for(int num: nums) {
            if(count == 0) maj = num;
            if(maj!=num) count--;
            else count++;
        }
        return maj;
    }

}
