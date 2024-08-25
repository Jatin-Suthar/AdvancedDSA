package DynamicProgrammingPatterns.Linear;

import java.util.*;

public class FindTheCountWhichAreNotSpecial {

    public static void main(String[] args) {

        FindTheCountWhichAreNotSpecialSolution solution = new FindTheCountWhichAreNotSpecialSolution();
        System.out.println(solution.nonSpecialCount(4, 16));

    }

}


class FindTheCountWhichAreNotSpecialSolution {
    private List<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r);
        List<Integer> primes = generatePrimes(limit);

        Set<Integer> specialNumbers = new HashSet<>();
        for (int prime : primes) {
            int specialNumber = prime * prime;
            if (specialNumber >= l && specialNumber <= r) {
                specialNumbers.add(specialNumber);
            }
        }

        int totalNumbers = r - l + 1;
        int specialCount = specialNumbers.size();
        return totalNumbers - specialCount;
    }
}