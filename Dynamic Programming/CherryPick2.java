//Recursive Solution
// TC: O(3^N*3 ^N)
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        return cherryPickupUtils(0, 0, n-1, m, n, grid);  
    }
    
    private int cherryPickupUtils(int i, int j1, int j2, int m, int n, int[][] grid){
        
        //Base cases
        
        //1. out of bound(columns are out of Bound)
        if(j1<0 || j2<0 || j1>=n || j2>=n) return -(int)Math.pow(10,9);
        
        //2. destination(reached last row)
        if(i == m-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        int maxi = 0;
        
        //For every movement of Robot 1, Robot 2 will have 3 choices for e.g robot1 moves to leftDiagonal, for that move robot 2 will have 
        //option to move to leftDiagonal, down or RightDiagonal. Total combination will be 3*3 = 9
        for(int dj1 = -1;dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1;dj2++){
                //Robot1 and Robot 2 are on same cell, in that case add cherry one time
                if(j1==j2)
                    maxi = Math.max(maxi, grid[i][j1] + cherryPickupUtils(i+1, j1+dj1, j2+dj2, m,n,grid));
                else
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + cherryPickupUtils(i+1, j1+dj1, j2+dj2, m,n,grid));
            }
        }
        return maxi;
        
    }
}

//Memoization solution
// TC: O(N*M*M) * 9
// SC: O(N) + O(N*M*M)
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][][] = new int[m][n][n];

    for (int row1[][]: dp) {
      for (int row2[]: row1) {
        Arrays.fill(row2, -1);
      }
    }

        return cherryPickupUtils(0, 0, n-1, m, n, grid, dp);  
    }
    
    private int cherryPickupUtils(int i, int j1, int j2, int m, int n, int[][] grid, int[][][] dp){
        
        //Base cases
        
        //1. out of bound(columns are out of Bound)
        if(j1<0 || j2<0 || j1>=n || j2>=n) return -(int)Math.pow(10,9);
        
        //2. destination(reached last row)
        if(i == m-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        int maxi = 0;
        
        //For every movement of Robot 1, Robot 2 will have 3 choices for e.g robot1 moves to leftDiagonal, for that move robot 2 will have 
        //option to move to leftDiagonal, down or RightDiagonal. Total combination will be 3*3 = 9
        for(int dj1 = -1;dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1;dj2++){
                //Robot1 and Robot 2 are on same cell, in that case add cherry one time
                if(j1==j2)
                    maxi = Math.max(maxi, grid[i][j1] + cherryPickupUtils(i+1, j1+dj1, j2+dj2, m,n,grid, dp));
                else
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] + cherryPickupUtils(i+1, j1+dj1, j2+dj2, m,n,grid, dp));
            }
        }
        return dp[i][j1][j2] = maxi;
        
    }
}
