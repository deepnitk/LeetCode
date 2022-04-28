//Recursive solution

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return (int)maxProfitUtils(0, 1, prices, n);
    }
    
    private long maxProfitUtils(int idx, int buy, int[] prices, int n){
        if(idx >= n)
            return 0;
        
        long profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[idx]+maxProfitUtils(idx+1, 0, prices, n),
                             0 + maxProfitUtils(idx+1,1, prices, n));
        }
        else{
            profit = Math.max(prices[idx] + maxProfitUtils(idx+2,1, prices, n),
                             0 + maxProfitUtils(idx+1,0, prices, n));
        }
        return profit;
    }
}

//Tabulation solution
class Solution {
    public int maxProfit(int[] prices) {

        return maxProfitUtils(prices);
    }
    
    private int maxProfitUtils(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+2][2];
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
                    profit = Math.max(prices[i] + dp[i+2][1],
                                     0 + dp[i+1][0]);
                }
                dp[i][j] = (int)profit;
            }
        }
        return dp[0][1];

    }
}
