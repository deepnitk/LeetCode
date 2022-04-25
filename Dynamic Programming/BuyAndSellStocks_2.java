//Recursive solution
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return (int)maxProfitUtils(0, 1, prices, n);
    }
    private long maxProfitUtils(int idx, int buy, int[] prices, int n){
        if(idx == n)
            return 0;
        
        long profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx]+maxProfitUtils(idx+1, 0, prices, n),
                             0 + maxProfitUtils(idx+1,1, prices, n));
        }
        else{
            profit = Math.max(prices[idx] + maxProfitUtils(idx+1,1, prices, n),
                             0 + maxProfitUtils(idx+1,0, prices, n));
        }
        return profit;
    }
}
//Memoization solution
//TC:O(N*2)
//SC(N*2) + ASA
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return (int)maxProfitUtils(0, 1, prices, n, dp);
    }
    private int maxProfitUtils(int idx, int buy, int[] prices, int n, int[][]dp){
        if(idx == n)
            return 0;
        
        if(dp[idx][buy]!= -1) return dp[idx][buy];
        long profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx]+maxProfitUtils(idx+1, 0, prices, n, dp),
                             0 + maxProfitUtils(idx+1,1, prices, n, dp));
        }
        else{
            profit = Math.max(prices[idx] + maxProfitUtils(idx+1,1, prices, n, dp),
                             0 + maxProfitUtils(idx+1,0, prices, n, dp));
        }
        return dp[idx][buy] = (int)profit;
    }
}

//Tabulation solution
//TC:O(N*2)
//SC:0(N*2)

class Solution {
    public int maxProfit(int[] prices) {
        
        return (int)maxProfitUtils(prices);
    }
    private int maxProfitUtils(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        //Base case
        dp[n][0] = dp[n][1] = 0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                long profit = 0;
                if(j == 1){
                    profit = Math.max(-prices[i]+dp[i+1][0],
                                     0 + dp[i+1][1]);
                }
                else{
                    profit = Math.max(prices[i] + dp[i+1][1],
                                     0 + dp[i+1][0]);
                }
                dp[i][j] = (int)profit;
            }
        }
        return dp[0][1];

    }
}
