package SlidingWindow;

import java.util.*;

/*
Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 */

public class FruitsInBasket {

    public static void main(String[] args) {

        int[] arr = {1,0,1,4,1,4,1,2,3};
        FruitsInBasketSolution solution = new FruitsInBasketSolution();
        System.out.println(solution.totalFruit(arr));

    }

}

class FruitsInBasketSolution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int start = 0;
        int end = 0;
        int n = fruits.length;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        while (end < n) {
            int currentFruit = fruits[end];
            fruitCount.put(currentFruit, fruitCount.getOrDefault(currentFruit, 0) + 1);
            end++;
            while (fruitCount.size() > 2) {
                int startFruit = fruits[start];
                fruitCount.put(startFruit, fruitCount.get(startFruit) - 1);
                if (fruitCount.get(startFruit) == 0) {
                    fruitCount.remove(startFruit);
                }
                start++;
            }
            maxFruits = Math.max(maxFruits, end - start);
        }
        return maxFruits;
    }
}