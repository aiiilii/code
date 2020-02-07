public class AddAndSearchWordDataStructure {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private TrieNode root;

    public AddAndSearchWordDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (int i =0 ; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int k, TrieNode temp) {
        if (k == chars.length) {
            return temp.isWord;
        }
        if (chars[k] == '.') {
            for (int i = 0; i < temp.children.length; i++) {
                if (temp.children[i] != null && match(chars, k+ 1, temp.children[i])) {
                    return true;
                }
            }
        } else {
            return temp.children[chars[k] - 'a'] != null && match(chars, k + 1, temp.children[chars[k] - 'a']);
        }
        return false;
    }
}