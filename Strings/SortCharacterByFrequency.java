package Strings;

import java.util.*;

public class SortCharacterByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new TreeMap<>(Collections.reverseOrder());
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        List<Pair> pairList = new ArrayList<>();
        for(char c: freqMap.keySet()) {
            pairList.add(new Pair(c, freqMap.get(c)));
        }
        pairList.sort(Comparator.comparing((Pair p) -> p.freq).reversed());
        for(Pair p: pairList) {
            int freq = p.freq;
            char c = p.c;
            while(freq-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}

class Pair {
    char c;
    int freq;
    Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
