//Memoization
//TC:O(N)
//TC:O(N) + ASA
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climStairsUtils(n, dp);
    }
    
    private int climStairsUtils(int n, int[] dp){
        if(n<=2) return n;
        if(dp[n] != -1) return dp[n];
        return climStairsUtils(n-1, dp) + climStairsUtils(n-2, dp);
    }
}

//Tabulation
//TC:O(N)
//SC:O(N)
class Solution {
    public int climbStairs(int n) {
        
        return climStairsUtils(n);
    }
    
    private int climStairsUtils(int n){
        //Cornet Case: if n <= 2
        if(n<=2) return n;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        
        for(int i=0;i<=2;i++)
            dp[i]=i;

        for(int i=3;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        return dp[n];
    }
}
