class Solution {
    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int mini = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length; i++) {
            mini = Math.min(mini, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - mini);
        }
        return maxPro;
    }
}
