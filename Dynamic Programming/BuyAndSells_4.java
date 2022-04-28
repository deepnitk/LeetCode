class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxProfitUtil(prices, k);
    }
    
    private int maxProfitUtil(int[] prices, int k){

        int n = prices.length;
        int[][] after = new int[2][k+1];
        for (int[] row : after) {
            Arrays.fill(row, 0);
        }
        int[][] curr = new int[2][k+1];
        for (int[] row : curr) {
            Arrays.fill(row, 0);
        }

        //Base cases are not needed as we are already initializing with 0

        for(int idx = n-1;idx>=0;idx--){
            for(int buy =0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    if(buy==1){
                        curr[buy][cap] = Math.max(-prices[idx] + after[0][cap],
                                                    0 + after[1][cap]);
                    }
                    else {
                        curr[buy][cap] = Math.max(prices[idx] + after[1][cap-1],
                                                        0 + after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return after[1][k];

    }
}
