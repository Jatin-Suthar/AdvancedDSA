package Graphs;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog"; List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
        WordLadderIISolution solution = new WordLadderIISolution();
        System.out.println(solution.findLadders(beginWord, endWord, wordList));
    }
}

class WordLadderIISolution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> levelMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>(wordList);
        q.add(beginWord);
        levelMap.put(beginWord, 0);
        wordSet.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.poll();
            int level = levelMap.get(word);
            if(word.equals(endWord)) { break; }
            for (int i = 0; i < word.length(); i++) {
                for(char c = 'a'; c <= 'z'; c++) {
                    char[] chars = word.toCharArray();
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(wordSet.contains(newWord)) {
                        q.add(newWord);
                        wordSet.remove(newWord);
                        levelMap.put(newWord, level + 1);
                    }
                }
            }
        }
        if(levelMap.get(endWord) != null) {
            List<String> carry = new ArrayList<>();
            carry.add(endWord);
            dfs(levelMap, endWord, carry, beginWord);
        }
        return ans;
    }
    public void dfs(Map<String, Integer> levelMap, String word, List<String> wordList, String targetWord) {
        if(word.equals(targetWord)) {
            List<String> temp = new ArrayList<>(wordList);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        for(int i=0; i<word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                char[] chars = word.toCharArray();
                chars[i] = c;
                String newWord = new String(chars);
                int oldWordLevel = levelMap.get(word);
                if(levelMap.containsKey(newWord) && oldWordLevel-1 == levelMap.get(newWord)) {
                    wordList.add(newWord);
                    dfs(levelMap, newWord, new ArrayList<>(wordList), targetWord);
                    wordList.remove(wordList.size()-1);
                }
            }
        }
    }
}