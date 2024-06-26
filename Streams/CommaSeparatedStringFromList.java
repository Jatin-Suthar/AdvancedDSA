package Streams;

import java.util.*;
import java.util.stream.Collectors;

public class CommaSeparatedStringFromList {

    public static void main(String[] args) {
        List<String> list = List.of("Jatin", "Jayesh", "Bhavesh");
        String s = list.stream().collect(Collectors.joining(", "));
        System.out.println(s);
    }

}
