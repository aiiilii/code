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
        TrieNode root = buildTrie(words); // put all the String[] words into a trie;

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
        temp = temp.children[c - 'a']; // simulating index -> index + 1;
        if (temp.theWord != null) { // found one,
            res.add(temp.theWord);
            temp.theWord = null; // de-duplicate, do not want to find the same word twice;
        }

        board[i][j] = '#';

        int[] dx = new int[] {-1, 0, 0, 1};
        int[] dy = new int[] {0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            if ((i + dx[k] >= 0 && i + dx[k] < board.length) && (j + dy[k] >= 0 && j + dy[k] < board[0].length)) { // if in bounds, then go 4 directions;
                dfs(board, i + dx[k], j + dy[k], temp, res);
            }
        }

        board[i][j] = c;
    }
}