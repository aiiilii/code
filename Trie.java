public class Trie {

    public class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode() {}
        TrieNode(char c) { val = c; }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode(c);
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (int i =0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (temp.children[c - 'a'] == null) {
                return false;
            }
            temp = temp.children[c - 'a'];
        }
        return true;
    }
}