package Streams;

import java.util.*;

public class FindShortestString {

    public static void main(String[] args) {
        List<String> fruits = List.of("Apple", "Banana", "Oranges");
        Optional<String> s = fruits.stream().min(Comparator.comparing(String::length));
        System.out.println(s.get());
    }

}
