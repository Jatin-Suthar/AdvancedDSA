package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class MapEvenOrNot {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> groupedByPrime = numbers.stream()
                .collect(Collectors.groupingBy(n -> n%2==0));
        System.out.println(groupedByPrime);
    }

}
