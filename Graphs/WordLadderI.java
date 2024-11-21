package Graphs;

import java.util.*;

// https://leetcode.com/problems/word-ladder/description/

public class WordLadderI {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog"; String[] wordList = {"hot","dot","dog","lot","log","cog"};
        WordLadderISolution solution = new WordLadderISolution();
        System.out.println(solution.wordLadderLength(beginWord, endWord, wordList));
    }

}

class WordLadderISolution {
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Queue<WordLadderIPair> q = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(wordList));
        set.remove(startWord);
        q.add(new WordLadderIPair(startWord, 1));
        while(!q.isEmpty()) {
            WordLadderIPair p = q.poll();
            String word = p.word;
            int sequence = p.seq;
            if(word.equals(targetWord)) return sequence;
            for(int i=0; i<word.length(); i++) {
                for(char c='a'; c<='z'; c++) {
                    char[] chars = word.toCharArray();
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(set.contains(newWord)) {
                        set.remove(newWord);
                        q.add(new WordLadderIPair(newWord, sequence+1));
                    }
                }
            }
        }
        return 0;
    }
}

class WordLadderIPair {
    String word;
    int seq;
    public WordLadderIPair(String word, int seq) {
        this.word = word;
        this.seq = seq;
    }
}