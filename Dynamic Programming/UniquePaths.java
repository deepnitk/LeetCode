//Recursive Solution
// TC: O(2^M*N)
// SC: O(Path Length) + O(2^M*N) path length = (m-1) + (n-1)
class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathUtils(m-1, n-1);
    }
    
    private int uniquePathUtils(int i, int j){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        int top = uniquePathUtils(i-1, j);
        int left = uniquePathUtils(i, j-1);
        return top+left;
    }
}

//Memoization solution
//TC: O(M*N)
//SC: O(Path length) + O(M*N)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePathUtils(m-1, n-1, dp);
    }
    
    private int uniquePathUtils(int i, int j, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int top = uniquePathUtils(i-1, j, dp);
        int left = uniquePathUtils(i, j-1, dp);
        return dp[i][j] =top+left;
    }
}

//Tabulation solution
//TC: O(M*N)
//SC: O(M*N)

class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathUtils(m, n);
    }
    
    private int uniquePathUtils(int m, int n){
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

//Space Optimized Soluyion
//TC: O(M*N)
//SC: O(N)
class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePathUtils(m, n);
    }
    
    private int uniquePathUtils(int m, int n){
        
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        
        for(int i=0;i<m;i++){
                int[] temp = new int[n];
                Arrays.fill(temp, 0);
            for(int j=0; j<n;j++){
                //base condition
                  if(i==0 && j==0){
                      temp[j]=1;
                      continue;
                  }
                int top = 0;
                int left = 0;
                if(i>0) top = dp[j];
                if(j>0) left = temp[j-1];
                temp[j] = top + left;
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
