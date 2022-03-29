//Recursive solution
//TC: O(3^N)
//SC: O(3^N)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxi = Integer.MAX_VALUE;
        for(int j=0; j< n;j++){
            int ans = minFallingPathSumUtils(m-1, j, matrix);
            maxi = Math.min(maxi, ans);
        }
        return maxi;
    }
    
    private int minFallingPathSumUtils(int i, int j, int[][] matrix){
        //Base case
        // out of bound
        if(j<0 || j >= matrix.length) return (int)Math.pow(10,9);
        // Destination
        if(i == 0) return matrix[0][j];
        
        int s = matrix[i][j] + minFallingPathSumUtils(i-1, j, matrix);
        int ld = matrix[i][j] + minFallingPathSumUtils(i-1, j-1, matrix);
        int rd = matrix[i][j] + minFallingPathSumUtils(i-1, j+1, matrix);
        
        return Math.min(s, Math.min(ld, rd));
        
    }
    
}

//Memoization
//TC: O(N*N)
//SC: O(N) + O(N*M)
//Reason: We are using a recursion stack space: O(N), where N is the path length and an external DP Array of size ‘N*M’.

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        int maxi = Integer.MAX_VALUE;
        for(int j=0; j< n;j++){
            int ans = minFallingPathSumUtils(m-1, j, matrix, dp);
            maxi = Math.min(maxi, ans);
        }
        return maxi;
    }
    
    private int minFallingPathSumUtils(int i, int j, int[][] matrix, int[][] dp){
        //Base case
        // out of bound
        if(j<0 || j >= matrix.length) return (int)Math.pow(10,9);
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int s = matrix[i][j] + minFallingPathSumUtils(i-1, j, matrix, dp);
        int ld = matrix[i][j] + minFallingPathSumUtils(i-1, j-1, matrix, dp);
        int rd = matrix[i][j] + minFallingPathSumUtils(i-1, j+1, matrix, dp);
        
        return dp[i][j] = Math.min(s, Math.min(ld, rd));
        
    }
    
}

//Tabulation solution
//TC: O(N*M)
//SC: O(N*M)
//Reason: We are using an external array of size ‘N*M’. The stack space will be eliminated.
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        return minFallingPathSumUtils(matrix);
    }
    
    private int minFallingPathSumUtils(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, 0);
        
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j];
        }
       

        for(int i=1;i<m;i++){
            for(int j =0; j<n; j++){
                int up = matrix[i][j] + dp[i-1][j];
                
                int leftDiagonal = matrix[i][j];
                if(j-1>=0) leftDiagonal+= dp[i-1][j-1];
                else leftDiagonal += (int)Math.pow(10,9);
                
                int rightDiagonal = matrix[i][j];
                if(j+1< n) rightDiagonal += dp[i-1][j+1];
                else rightDiagonal += (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        
        int maxi = Integer.MAX_VALUE;
        for(int j=0; j< n;j++){
            int ans = dp[m-1][j];
            maxi = Math.min(maxi, ans);
        }

        return maxi;
        
    }
    
}
