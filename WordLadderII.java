import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderII {

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (wordList == null || wordList.size() == 0) {
            return res;
        }
        Set<String> dict = new HashSet<String>(wordList);
        if (!dict.contains(endWord)) {
            return res;
        }
        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        List<String> templist = new ArrayList<String>();

        dict.add(beginWord);

        bfs(beginWord, endWord, dict, nodeNeighbors, distance);
        dfs(beginWord, endWord, dict, nodeNeighbors, distance, templist, res);

        return res;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<String>());
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                int currDistance = distance.get(curr);
                ArrayList<String> neighbors = getNeighbors(curr, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(curr).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, currDistance + 1);
                        if (end.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
                if (foundEnd) {
                    break;
                }
            }
        }
    }

    private ArrayList<String> getNeighbors(String curr, Set<String> dict) {
        ArrayList<String> neighbors = new ArrayList<String>();
        char[] chars = curr.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char orig = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch ++) {
                if (chars[i] == ch) {
                    continue;
                }
                chars[i] = ch;
                if (dict.contains(String.valueOf(chars))) {
                    neighbors.add(String.valueOf(chars));
                }
                chars[i] = orig;
            }
        }
        return neighbors;
    }

    private void dfs(String curr, String end, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance, List<String> templist, List<List<String>> res) {
        templist.add(curr);
        if (end.equals(curr)) {
            res.add(new ArrayList<String>(templist));
        } else {
            for (String next : nodeNeighbors.get(curr)) {
                if (distance.get(next) == distance.get(curr) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, templist, res);
                }
            }
        }
        templist.remove(templist.size() - 1);
    }
















    Map<String, List<String>> map = new HashMap<String, List<String>>();
    Set<String> doneSet = new HashSet<String>();
    Map<String, Integer> depthMap = new HashMap<String, Integer>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        buildMap(wordList, beginWord);
        int minLength = BFS(beginWord, endWord, wordList);
        doneSet.clear();
        LinkedList<String> currList = new LinkedList<String>();
        List<List<String>> result = new LinkedList<List<String>>();
        currList.add(endWord);
        doneSet.add(endWord);
        DFS(currList, result, beginWord, minLength, 1);
        return result;
    }

    public void buildMap(List<String> wordList, String beginWord) {
        Set<String> wordSet = new HashSet<String>();
        for (String str : wordList) {
            wordSet.add(str);
        }
        wordSet.add(beginWord);

        for (String str: wordSet) {
            map.put(str, new LinkedList<String>());
            diff(str, wordSet);
        }
    }

    public void diff(String s, Set<String> wordSet) {
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            char curr = sb.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr != c) {
                    sb.setCharAt(i, c);
                    if (wordSet.contains(sb.toString())) {
                        map.get(s).add(sb.toString());
                    }
                }
            }
        }
    }

    public int BFS(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        doneSet.add(beginWord);
        depthMap.put(beginWord, 0);
        int steps = 1;
        
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return steps;
                }
                if (map.containsKey(curr)) {
                    List<String> nextStrList = map.get(curr);
                    for (String nextStr : nextStrList) {
                        if (!depthMap.containsKey(nextStr)) {
                            queue.offer(nextStr);
                            depthMap.put(nextStr, steps);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public void DFS(LinkedList<String> currList, List<List<String>> result, String target, int minLength, int currDepth) {
        String currString = currList.get(0);
        if (currList.size() > minLength) {
            return;
        } else if (currList.size() == minLength) {
            if (currString.equals(target)) {
                result.add(new LinkedList<String>(currList));
            }
        } else {
            for (String str : map.get(currString)) {
                if (!doneSet.contains(str) && depthMap.containsKey(str) && depthMap.get(str) + currDepth < minLength) {
                    currList.addFirst(str);
                    doneSet.add(str);
                    DFS(currList, result, target, minLength, currDepth + 1);
                    doneSet.remove(str);
                    currList.removeFirst();
                }
            }
        }
    }
}