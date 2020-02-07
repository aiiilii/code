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

    // Returns if the word is in the data structure.
    // A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chars, int k, TrieNode temp) {
        if (k == chars.length) {
            return temp.isWord;
        }
        if (chars[k] == '.') {
            for (int i = 0; i < temp.children.length; i++) { // temp.children.lenth == 26, checking all children to see if present
                if (temp.children[i] != null && match(chars, k + 1, temp.children[i])) {
                    return true;
                }
            }
        } else {
            return temp.children[chars[k] - 'a'] != null && match(chars, k + 1, temp.children[chars[k] - 'a']);
        }
        return false;
    }

    public static void main(String[] args) {
        AddAndSearchWordDataStructure s = new AddAndSearchWordDataStructure();
        s.addWord("bad");
        s.addWord("dad");
        s.addWord("mad");
        System.out.println(s.search("b.."));
    }
}