import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WordLadder {

    /**
     * Bidirectional BFS - Super Fast
     * Time: O(N * M)
     * Space: O(M * N)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> begin = new HashSet<String>(); // has properties of both queue and set, can hold current level's strings, and can check if it contains duplicate strings
        Set<String> end = new HashSet<String>(); // elimate duplicate using dict.remove() so do not need another visited set;

        begin.add(beginWord);
        end.add(endWord);
        dict.remove(beginWord);
        dict.remove(endWord);
        int step = 2; // 1 step from the front and 1 step from the back;

        while (!begin.isEmpty()) {
            Set<String> temp = new HashSet<String>(); // saving intermediate sets;
            for (String word : begin) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char orig = chars[i]; // storing the original letter so can change back after changing that letter with 'a' to 'z';
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (end.contains(newWord)) {
                            return step;
                        }
                        if (dict.contains(newWord)) {
                            temp.add(newWord); // add into the intermediate set;
                            dict.remove(newWord);
                        }
                    }
                    chars[i] = orig;
                }
            }
            step ++;
            if (temp.size() <= end.size()) { // always begin using the smaller sized set;
                begin = temp; 
            } else { // swap begin to the end and the end to temp, if temp.size() > end.size();
                begin = end;
                end = temp;
            }
        }
        return 0;
    }


    public static Map<String, List<String>> map = new HashMap<String, List<String>>();
    /**
     * Super slow haha
     * Time - O(N ^ 3)
     * Space - O(M * N)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        buildMap(wordList, beginWord);
        Set<String> doneSet = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();

        queue.offer(beginWord);
        doneSet.add(beginWord);
        int steps = 1; // start from 1 because asking for the total length, which includes the beginWord, not how many steps;

        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return steps;
                }
                List<String> nextStrList = map.get(curr);
                for (String nextStr : nextStrList) {
                    if (!doneSet.contains(nextStr)) {
                        queue.offer(nextStr);
                        doneSet.add(nextStr);
                    }
                }
            }
            steps ++;
        }
        return 0;
    }

    private static void buildMap(List<String> wordList, String beginWord) {
        for (String str : wordList) {
            List<String> newList = new LinkedList<String>();
            map.put(str, newList); // add each str and an empty list<String> into the map;
            for (String next : wordList) {
                if (diff(str, next) == 1) {
                    map.get(str).add(next); // if the difference between the two words is 1 letter, then add it to the list<String>;
                }
            }
        }
        if (!map.containsKey(beginWord)) { // if beginWord is not in the wordList already, then add it to the map as well;
            List<String> newList = new LinkedList<String>();
            map.put(beginWord, newList);
            for (String str : wordList) {
                if (diff(beginWord, str) == 1) {
                    map.get(beginWord).add(str);
                }
            }
        }
    }

    private static int diff(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "hot";
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}