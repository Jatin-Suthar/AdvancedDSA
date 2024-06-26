package Streams;

import java.util.*;

public class NthHighestNumber {

    public static void main(String[] args) {
        int n = 2;
        List<Integer> nums = List.of(3,4,2,7,8,4,3,6);
        Optional<Integer> num = nums.stream().sorted(Collections.reverseOrder()).skip(n-1).findFirst();
        System.out.println(num.get());
    }

}
