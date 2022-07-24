//Solution with space complexity

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i< n; i++) {
            for (int j = 0;j < n;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }
    
    private void dfs(int col, char[][] board, List<List<String>> res) {
        if ( col == board.length ) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length;row++) {
            if ( isSafe(board, row, col) ) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        
        //upper diagonal check
        while (row >= 0 && col >= 0) {
            if ( board[row][col] == 'Q' ) return false;
            row--;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        
        //left 
        while (col >= 0) {
            if ( board[row][col] == 'Q') return false;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        
        //lower diagonal check
        while ( col >= 0 && row < board.length) {
            if ( board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}

//Better approach

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i< n; i++) {
            for (int j = 0;j < n;j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        dfs(0, leftRow, upperDiagonal, lowerDiagonal,board, res);
        return res;
    }
    
    private void dfs(int col, int leftRow[], int upperDiagonal[], int lowerDiagonal[], char[][] board, List<List<String>> res) {
        if ( col == board.length ) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length;row++) {
            if ( leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 +col -row] == 0) {
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 +col -row] = 1;
                board[row][col] = 'Q';
                dfs(col + 1, leftRow, upperDiagonal, lowerDiagonal, board, res);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 +col -row] = 0;
            }
        }
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        
        //upper diagonal check
        while (row >= 0 && col >= 0) {
            if ( board[row][col] == 'Q' ) return false;
            row--;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        
        //left 
        while (col >= 0) {
            if ( board[row][col] == 'Q') return false;
            col--;
        }
        
        row = dupRow;
        col = dupCol;
        
        //lower diagonal check
        while ( col >= 0 && row < board.length) {
            if ( board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
