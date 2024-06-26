package JavaPoints;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 5);

        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(i -> i)).entrySet().stream().filter(key -> key.getValue().size() > 1).map(Map.Entry::getKey).toList();
//                .entrySet()
//                .stream()
//                .filter(e -> e.getValue().size() > 1)
//                .map(e -> e.getKey())
//                .collect(Collectors.toList());

        System.out.println("Duplicate integers: " + duplicates);
    }


}
