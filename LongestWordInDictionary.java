public class LongestWordInDictionary {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String theWord = "";
        public TrieNode() {}
    }

    /**
     * Trie + DFS approach
     * Time - O(sum of length of words), build trie and search it;
     * Space - O(sum of length of words), used to build trie;
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.theWord = word;
        }

        return dfs(root);
    }

    private String dfs(TrieNode temp) {
        String res = temp.theWord;

        for (TrieNode child : temp.children) {
            if (child != null && child.theWord.length() != 0) {
                String childWord = dfs(child);
                if (childWord.length() > res.length() || (childWord.length() == res.length() && childWord.compareTo(res) < 0)) { // the second condition can be omitted;
                    res = childWord;
                }
            }
        }
        return res;
    }
}