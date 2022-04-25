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
