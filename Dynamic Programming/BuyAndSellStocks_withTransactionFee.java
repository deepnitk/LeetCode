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
