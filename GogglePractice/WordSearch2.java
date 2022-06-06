// Trie + DFS solution


//Declare Trie Node...
class TrieNode {
    TrieNode links[] = new TrieNode[26];
    boolean isWord = false;

    public TrieNode() {

    }

    boolean contains(char ch) {
        return (links[ch - 'a'] != null);
    }

    void put(char ch ,TrieNode node) {
        links[ch - 'a'] = node;
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }
};

class Solution {    
    private static TrieNode root;
    
    public Solution() {
        root = new TrieNode();
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        //Insert every word in Trie...
        for(String word: words) {
            insert(word);
        }
        
        int rows = board.length;
        int cols = board[0].length;
        HashSet<String> res = new HashSet<>();
        for(int i = 0;i < rows; i++) {
            for(int j = 0;j < cols; j++) {
                callDfs(board, i, j, rows, cols , res, root, new StringBuilder());
            }
        }
        return new ArrayList<>(res);
        
    }
    
    public void insert(String word) {
        TrieNode node = root;
        
        for(int i = 0; i < word.length(); i++) {
            if ( !node.contains(word.charAt(i)) ) {
                node.put(word.charAt(i), new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.isWord = true;   
    }
    
    public void callDfs(char[][] board, int r, int c, int rows, int cols, HashSet<String> res, TrieNode root, StringBuilder word) {
        //Base case
        if ( r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] == '#' || !root.contains(board[r][c])) {
            return;
        }
        
        // ch contains in Trie
        char ch = board[r][c];
        
        // Add that ch to word..
        word.append(ch);
        
        TrieNode node = root.get(ch);

        if ( node.isWord ) {
            res.add(word.toString());
        }
        

        board[r][c] = '#';
        
        callDfs(board, r + 1, c, rows, cols, res, node, word);
        callDfs(board, r - 1, c, rows, cols, res, node, word);
        callDfs(board, r, c + 1, rows, cols, res, node, word);
        callDfs(board, r, c - 1, rows, cols, res, node, word);
        
        //Backtrack ...
        word.deleteCharAt(word.length() - 1);
        board[r][c] = ch; 
    }
}
