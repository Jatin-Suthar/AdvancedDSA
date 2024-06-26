package Streams;

import java.util.*;

public class FindAllPositiveOrNot {

    public static void main(String[] args) {
        List<Integer> positives = List.of(1,2,3,4,5,6);
        boolean isNotPositive = positives.stream().allMatch(num -> num>0);
        System.out.println(isNotPositive);
    }

}
