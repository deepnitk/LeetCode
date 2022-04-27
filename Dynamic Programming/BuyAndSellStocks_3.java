// Recursive Solution
// TC:O(exponential)
// SC:O(N)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return (int)maxProfitUtil(0,1,2, n,prices);
    }
    
    private long maxProfitUtil(int idx, int buy, int cap, int n, int[] prices){
        //Base Cases
        //1. completed 2 transactions
        if(cap==0) return 0;
        //2. reached end of prices array
        if(idx == n) return 0;
        
        long profit = 0;
        if(buy==1){
            profit = Math.max(-prices[idx] + maxProfitUtil(idx+1,0,cap,n,prices),
                             0+maxProfitUtil(idx+1,1,cap,n,prices));
        }
        else {
            profit = Math.max(prices[idx] + maxProfitUtil(idx+1,1,cap-1,n,prices),
                             0+maxProfitUtil(idx+1,0,cap,n,prices));
        }
        return profit;
    }
}
//Memoization solution
//TC:O(N*2*3)
//SC:O(N*2*3)+ASA
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] row : dp) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }
        return maxProfitUtil(0,1,2, n,prices, dp);
    }
    
    private int maxProfitUtil(int idx, int buy, int cap, int n, int[] prices, int[][][] dp){
        //Base Cases
        //1. completed 2 transactions
        if(cap==0) return 0;
        //2. reached end of prices array
        if(idx == n) return 0;
        
        long profit = 0;
        if(dp[idx][buy][cap] != -1) return dp[idx][buy][cap];
        if(buy==1){
            dp[idx][buy][cap] = Math.max(-prices[idx] + maxProfitUtil(idx+1,0,cap,n,prices,dp),
                             0+maxProfitUtil(idx+1,1,cap,n,prices,dp));
        }
        else {
            dp[idx][buy][cap] = Math.max(prices[idx] + maxProfitUtil(idx+1,1,cap-1,n,prices,dp),
                             0+maxProfitUtil(idx+1,0,cap,n,prices,dp));
        }
        return dp[idx][buy][cap];
    }
}