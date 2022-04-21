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
