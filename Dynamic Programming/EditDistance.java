//Recursive solution
//TC: Exponential

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return minDistanceUtils(n-1, m-1, word1, word2);
    }
    
    private int minDistanceUtils(int i, int j, String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(s1.charAt(i) == s2.charAt(j)) return 0 + minDistanceUtils(i-1, j-1, s1, s2);
        else{
            return Math.min(
                1 + minDistanceUtils(i-1,j, s1,s2), 
                Math.min(
                    1 + minDistanceUtils(i,j-1, s1,s2),
                    1 + minDistanceUtils(i-1,j-1, s1,s2)
                )
            );
        }
    }
}

//Memoization solution
//TC:O(N*M)
//SC:O(N*M) + O(N+M)
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return minDistanceUtils(n-1, m-1, word1, word2, dp);
    }
    
    private int minDistanceUtils(int i, int j, String s1, String s2, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 0 + minDistanceUtils(i-1, j-1, s1, s2, dp);
        else{
            return dp[i][j] = Math.min(
                1 + minDistanceUtils(i-1,j, s1,s2, dp), 
                Math.min(
                    1 + minDistanceUtils(i,j-1, s1,s2, dp),
                    1 + minDistanceUtils(i-1,j-1, s1,s2, dp)
                )
            );
        }
    }
}

//Tabulation solution
//TC:O(N*M)
//SC:O(N*M)
class Solution {
    public int minDistance(String word1, String word2) {
        
        return minDistanceUtils(word1, word2);
    }
    
    private int minDistanceUtils(String s1, String s2){
        
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        
        for(int i=0;i<=n;i++)
            dp[i][0] = i;
        for(int j=0;j<=m;j++)
            dp[0][j] =j;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                    dp[i][j] = 0 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(
                        1 + dp[i-1][j],
                        Math.min(
                            1 + dp[i][j-1],
                            1 + dp[i-1][j-1]
                        )
                    );
                }                
            }
        }
        return dp[n][m];
        
    }
}

//Space Optimization
//TC:O(N*M)
//SC:O(M)
class Solution {
    public int minDistance(String word1, String word2) {
        
        return minDistanceUtils(word1, word2);
    }
    
    private int minDistanceUtils(String s1, String s2){
        
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        Arrays.fill(prev, 0);
       
       for(int i=0;i<=m;i++)
           prev[i] =i;
        
        for(int i=1;i<=n;i++){
            int[] curr = new int[m+1];
            curr[0] = i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                    curr[j] = 0 + prev[j-1];
                else{
                    curr[j] = Math.min(
                        1 + prev[j],
                        Math.min(
                            1 + curr[j-1],
                            1 + prev[j-1]
                        )
                    );
                }                
            }
            prev = curr;
        }
        return prev[m];
        
    }
}
