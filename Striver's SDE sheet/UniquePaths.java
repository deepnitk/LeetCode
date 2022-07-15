//Brute force Recursive solution
//TC: exponential 2^m*n
// SC: exponential

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathsUtils(0, 0, m, n);
    }
    
    private int uniquePathsUtils(int i , int j, int m, int n) {
        if( i == m - 1 && j == n - 1) {
            return 1;
        }
        if ( i >= m || j >= n){
            return 0;
        }
        
        return uniquePathsUtils(i + 1, j, m, n) + uniquePathsUtils(i, j + 1, m, n);
    }
}

//DP solution
//TC: O(M*N)
//SC: O(M*N)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsUtils(0, 0, m, n, dp);
    }
    
    private int uniquePathsUtils(int i , int j, int m, int n, int[][] dp) {
        if( i == m - 1 && j == n - 1) {
            return 1;
        }
        if ( i >= m || j >= n){
            return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        else return dp[i][j] = uniquePathsUtils(i + 1, j, m, n, dp) + uniquePathsUtils(i, j + 1, m, n, dp);
    }
}
