//Recursive solution
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        return maxProfitUtil(0, 1, n, prices, fee);
    }
    public int maxProfitUtil(int idx, int buy, int n, int[] prices, int fee){
        
        if (idx == n){
            return 0;
        }
        int profit = 0;
        if (buy == 1){
            profit = Math.max(-prices[idx] + maxProfitUtil(idx+1,0,n,prices, fee),
                             0 + maxProfitUtil(idx+1, 1, n,prices, fee));
        }
        else {
            profit = Math.max(prices[idx] + maxProfitUtil(idx+1,1,n,prices, fee) - fee,
                             0 + maxProfitUtil(idx+1, 0, n, prices,fee));
        }
        return profit;
    }
}

//Tabulation solution

class Solution {
    public int maxProfit(int[] prices, int fee) {
        return (int)maxProfitUtils(prices, fee);
    }
    public int maxProfitUtils(int[] prices, int fee) {
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
                    profit = Math.max(prices[i] + dp[i+1][1] -fee ,
                                     0 + dp[i+1][0]);
                }
                dp[i][j] = (int)profit;
            }
        }
        return dp[0][1];
    }
}
