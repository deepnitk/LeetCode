//Mmemoization solution

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int row[]: dp)
            Arrays.fill(row,-1);
        
        return minPathSumUtils(m-1, n-1, grid, dp);
    }
    
    private int minPathSumUtils(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)Math.pow(10,9);
        
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + minPathSumUtils(i-1, j, grid, dp);
        int left = grid[i][j] + minPathSumUtils(i, j-1, grid, dp);
        
        return dp[i][j] = Math.min(up, left);
    }
}

//Tabulation solution
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        return minPathSumUtils(m, n, grid, dp);
    }
    
    private int minPathSumUtils(int m, int n, int[][] grid, int[][] dp){
        
        for(int i =0; i<m;i++){
            for(int j=0;j< n; j++){
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i>0) up += dp[i-1][j];
                    else up += (int)Math.pow(10,9);

                    int left = grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left += (int)Math.pow(10,9);
                    
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[m-1][n-1];
    }
}

//Space Optimization
// TC: O(M*N)
//SC: O(M*N)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        
        return minPathSumUtils(m, n, grid);
    }
    
    private int minPathSumUtils(int m, int n, int[][] grid){
        int[] dp = new int[n];
        for(int i =0; i<m;i++){
            int[] temp = new int[n];
            //Arrays.fill(temp, 0);
            for(int j=0;j< n; j++){
                if(i==0 && j==0) temp[j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i>0) up += dp[j];
                    else up += (int)Math.pow(10,9);

                    int left = grid[i][j];
                    if(j>0) left+=temp[j-1];
                    else left += (int)Math.pow(10,9);
                    
                    temp[j] = Math.min(up, left);
                }
            }
            dp = temp;
        }

        return dp[n-1];
    }
}
