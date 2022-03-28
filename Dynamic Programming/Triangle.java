//Recursive Solution

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(0).size();
        return minimumTotalUtil(0,0,triangle, m);
    }
    
    private int minimumTotalUtil(int i,int j, List<List<Integer>> triangle, int m) {
      //Base case
        if(i==m-1) return triangle.get(m-1).get(j);
        int down = triangle.get(i).get(j) + minimumTotalUtil(i+1, j, triangle, m);
        int diag = triangle.get(i).get(j) + minimumTotalUtil(i+1, j+1, triangle, m);
        return Math.min(down, diag);
    }
    
}

//Memoization
//TC: O(N*N)
//SC: O(N*N) + O(N)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(0).size();
        int[][] dp = new int[m][m];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return minimumTotalUtil(0,0,triangle, m, dp);
    }
    
    private int minimumTotalUtil(int i,int j, List<List<Integer>> triangle, int m, int[][] dp) {
      //Base case
        if(i==m-1) return triangle.get(m-1).get(j);
        if(dp[i][j] != -1) return dp[i][j];
        int down = triangle.get(i).get(j) + minimumTotalUtil(i+1, j, triangle, m, dp);
        int diag = triangle.get(i).get(j) + minimumTotalUtil(i+1, j+1, triangle, m, dp);
        return dp[i][j] = Math.min(down, diag);
    }
    
}

//Tabulation
//TC: O(N*N)
//SC: O(N*N)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        return minimumTotalUtil(triangle);
    }
    
    private int minimumTotalUtil(List<List<Integer>> triangle) {
        
        int m = triangle.size();
        int[][] dp = new int[m][m];
  
        //Base case
        for(int j=0;j<m;j++)
            dp[m-1][j] = triangle.get(m-1).get(j);
      
        for(int i=m-2;i>=0;i--){
            for(int j = i; j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }
    
}
