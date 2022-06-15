//TC: O(N! * N).
//SC:O(N*N)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveQueensUtils(0, board, res);
        return res;
    }
    
    private void solveQueensUtils(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                solveQueensUtils(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0;i < board.length;i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    private boolean isSafe(char[][] board, int row, int col) {
        int dupRow = row;
        int dupCol = col;
        //Upper diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            row -= 1;
            col -= 1;
        }
        row = dupRow;
        col = dupCol;
        // to the left 
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        //left down diagonal
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
}
