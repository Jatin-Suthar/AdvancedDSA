package DynamicProgrammingPatterns.Knapsack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialShoppingOffers {
    //price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
    public static void main(String[] args) {
        List<Integer> price = List.of(2, 5);
        List<List<Integer>> special = List.of(List.of(3,0,5), List.of(1,2,10));
        List<Integer> needs = List.of(3,2);
        SpecialShoppingOffersSolution solution = new SpecialShoppingOffersSolution();
        System.out.println(solution.shoppingOffers(price, special, needs));
    }
}

class SpecialShoppingOffersSolution {
    Map<String, Integer> map = new HashMap<>();
    public int
    shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return recur(price, special, new ArrayList<>(needs));
    }
    public int
    recur(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int sum = 0, len = price.size();
        StringBuilder cacheKeySb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            cacheKeySb.append(needs.get(i));
            sum += price.get(i)*needs.get(i);
        }
        String cacheKey = cacheKeySb.toString();
        if(map.get(cacheKey) != null) {
            return map.get(cacheKey);
        }
        for(int i=0; i<special.size(); i++) {
            List<Integer> list = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<len; j++) {
                if(needs.get(j)-list.get(j)<0) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j)-list.get(j));
            }
            if(temp != null) {
                sum = Math.min(sum, special.get(i).get(len)+recur(price, special, temp));
            }
        }
        for(int i=0; i<len; i++) {
            if(needs.get(i)-1>=0) {
                needs.set(i, needs.get(i) - 1);
                sum = Math.min(sum, price.get(i) + recur(price, special, needs));
                needs.set(i, needs.get(i) + 1);
            }
        }
        map.put(cacheKey, sum);
        return sum;
    }
}