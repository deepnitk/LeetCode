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
