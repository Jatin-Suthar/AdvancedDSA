package Streams;

import java.util.*;

public class SumOfAllElements {

    public static void main(String[] args) {
        List<Integer> list = List.of(5, 6, 3, 2, 9, 7);
        long sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }

}

