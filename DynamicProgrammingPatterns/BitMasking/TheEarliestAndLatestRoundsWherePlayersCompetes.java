package DynamicProgrammingPatterns.BitMasking;

import java.util.*;

public class TheEarliestAndLatestRoundsWherePlayersCompetes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().earliestAndLatest(11, 2, 4)));
    }
    static class Solution {
        private Map<Integer, int[]> memo;
        private int firstPlayer;
        private int secondPlayer;

        public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
            this.memo = new HashMap<>();
            this.firstPlayer = Math.min(firstPlayer, secondPlayer);
            this.secondPlayer = Math.max(firstPlayer, secondPlayer);
            int initialMask = (1 << n) - 1;
            return solve(initialMask);
        }

        private int[] solve(int mask) {
            if (memo.containsKey(mask)) {
                return memo.get(mask);
            }

            List<Integer> currentPlayers = new ArrayList<>();
            for (int i = 0; i < 28; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentPlayers.add(i + 1);
                }
            }

            int numPlayers = currentPlayers.size();
            int idx1 = currentPlayers.indexOf(this.firstPlayer);
            int idx2 = currentPlayers.indexOf(this.secondPlayer);

            if (idx1 + idx2 == numPlayers - 1) {
                return new int[]{1, 1};
            }

            int minRounds = Integer.MAX_VALUE;
            int maxRounds = Integer.MIN_VALUE;

            List<Integer> nextMasks = new ArrayList<>();
            generateNextMasks(0, 0, currentPlayers, nextMasks);

            for (int nextMask : nextMasks) {
                int[] result = solve(nextMask);
                minRounds = Math.min(minRounds, result[0] + 1);
                maxRounds = Math.max(maxRounds, result[1] + 1);
            }

            int[] answer = new int[]{minRounds, maxRounds};
            memo.put(mask, answer);
            return answer;
        }

        private void generateNextMasks(int matchIndex, int currentNextMask, List<Integer> players, List<Integer> nextMasks) {
            int numPlayers = players.size();
            int totalMatches = numPlayers / 2;

            if (matchIndex == totalMatches) {
                if (numPlayers % 2 == 1) {
                    int middlePlayer = players.get(totalMatches);
                    currentNextMask |= (1 << (middlePlayer - 1));
                }
                nextMasks.add(currentNextMask);
                return;
            }

            int pLeft = players.get(matchIndex);
            int pRight = players.get(numPlayers - 1 - matchIndex);

            if (pLeft == this.firstPlayer || pLeft == this.secondPlayer) {
                generateNextMasks(matchIndex + 1, currentNextMask | (1 << (pLeft - 1)), players, nextMasks);
            } else if (pRight == this.firstPlayer || pRight == this.secondPlayer) {
                generateNextMasks(matchIndex + 1, currentNextMask | (1 << (pRight - 1)), players, nextMasks);
            } else {
                generateNextMasks(matchIndex + 1, currentNextMask | (1 << (pLeft - 1)), players, nextMasks);
                generateNextMasks(matchIndex + 1, currentNextMask | (1 << (pRight - 1)), players, nextMasks);
            }
        }
    }
/**
 2 4
 1 2 3 4 5 6 7 8 9 10 11
 2 3 4 5 6 11
 2 3 4

 2 8
 1 2 3 4 5 6 7 8 9 10 11
 1 2 3 5 6 8
 2 3 8

 */
}
