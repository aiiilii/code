import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignSearchAutocompleteSystem {

    public class TrieNode {
        public Map<Character, TrieNode> children;
        public Map<String, Integer> counts;
        public boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
        }
    }

    public class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    public TrieNode root;
    public String prefix;

    /**
     * Time - O(k * l), iterate over l sentences each of average length k
     * Space - O(p + q + m log m), p is teh length of the sentence formed till now, q refers to the number of nodes in the trie considering the sentence formed till now as the root node.
     * Sorting the list of length m indicating the options available for the hot sentences, which takes O(m log m).
     * @param sentences
     * @param times
     */
    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (temp.children.get(c) == null) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
            temp.counts.put(s, temp.counts.getOrDefault(s, 0) + count);
        }
        temp.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.children.get(ch) == null) {
                return new ArrayList<String>();
            }
            temp = temp.children.get(ch);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));

        for (String s : temp.counts.keySet()) {
            pq.offer(new Pair(s, temp.counts.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }
}