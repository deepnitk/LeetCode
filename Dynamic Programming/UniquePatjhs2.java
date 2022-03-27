//Memoization solution
//TC: O(M*N)
//SC: O(M*N)+O(2^M*N)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePathUtils(m-1, n-1, dp, obstacleGrid);
    }
    
    private int uniquePathUtils(int i, int j, int[][] dp, int[][] obstacleGrid){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0 || obstacleGrid[i][j]==1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int top = uniquePathUtils(i-1, j, dp, obstacleGrid);
        int left = uniquePathUtils(i, j-1, dp, obstacleGrid);
        return dp[i][j] =top+left;
    }
}

//Tabulation
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        return uniquePathUtils(m, n, obstacleGrid);
    }
    
    private int uniquePathUtils(int m, int n, int[][] obstacleGrid){
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                //base condition
                  if(i==0 && j==0){
                      dp[i][j]=1;
                      continue;
                  }
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j]=0;
                    continue;
                }
                int top = 0;
                int left = 0;
                if(i>0) top = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = top + left;
            }
        }
        return dp[m-1][n-1];
    }
}
