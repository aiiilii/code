import java.util.List;

public class ReplaceWords {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String theWord;
        public TrieNode() {}
    }

    /**
     * Time - O(n), n is the length of the sentence
     * Space - O(n), size of our trie
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();

        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.theWord = word;
        }

        StringBuilder sb = new StringBuilder();

        for (String word : sentence.split("\\s+")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }

            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null || temp.theWord != null) {
                    break;
                }
                temp = temp.children[c - 'a'];
            }
            if (temp.theWord != null) {
                sb.append(temp.theWord);
            } else {
                sb.append(word);
            }
        }
        return sb.toString();
    }
}