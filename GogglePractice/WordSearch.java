// TC: O(M*N* 4^len(word)
//Explaination we are calling dfs for every element of board tc: o(m*n*dfs). dfs = 4^len(word). calling dfs 4 times.
class Solution {
    static boolean[][] visited ;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j< n; j++) {
                if ( board[i][j] == word.charAt(0) && ifExists(board, i, j, m, n, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean ifExists(char[][] board, int r, int c, int m, int n, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }
        if( r < 0 || c < 0 || r >= m || c >= n || word.charAt(idx) != board[r][c] || visited[r][c]) {
            return false;
        }
        
        visited[r][c] = true;
        if(ifExists(board, r + 1, c, m, n, word, idx+1) ||
            ifExists(board, r - 1, c, m, n, word, idx+1) ||
            ifExists(board, r, c + 1, m, n, word, idx+1) ||
            ifExists(board, r, c - 1, m, n, word, idx+1)) {
            return true;
        }
        visited[r][c] = false;
        return false;
    }
}
