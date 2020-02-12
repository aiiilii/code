import java.util.List;
import java.util.ArrayList;

public class WordSearchII {

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String theWord;
        public TrieNode() {}
    }

    /**
     * Backtracking + Trie
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode temp = root;
            for (char c : w.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.theWord = w;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode temp, List<String> res) {
        char c = board[i][j];
        if (c == '#' || temp.children[c - 'a'] == null) {
            return;
        }
        temp = temp.children[c - 'a'];
        if (temp.theWord != null) { // found one,
            res.add(temp.theWord);
            temp.theWord = null; // de-duplicate;
        }

        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, temp, res);
        }
        if (j > 0) {
         dfs(board, i, j - 1, temp, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, temp, res);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, temp, res);
        }
        board[i][j] = c;
    }
}