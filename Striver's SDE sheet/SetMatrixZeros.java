/*
Brute force approach
TC:  O(M*N)*O(M*N)
SC: O(1)
*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int  i = 0;i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (matrix[i][j] == 0) {
                    changeRowCol(matrix, i, j, m, n);
                }
            }
        }
        for (int  i = 0;i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    private void changeRowCol(int[][] matrix, int row, int col, int m, int n) {
        for(int i = 0; i < m; i++) {
            if(matrix[i][row] != 0) {
                matrix[i][row] = -1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[col][i] != 0) {
                matrix[col][i] = -1;
            }
        }        
    }
}

/*
Bettere approach
TC: o(m+n) + o(m+n)
sc: o(m) + o(n)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        Arrays.fill(row , -1);
        Arrays.fill(col , -1);
        for (int  i = 0;i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        for (int  i = 0;i < m; i++) {
            for (int j = 0; j< n; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
