//Recursive solution
//TC: O(2^N)

class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeUtil(coins.length-1, coins, amount);
    }
    
    private int coinChangeUtil(int idx, int[] coins, int amount){
        if(idx==0) {
            if((amount % coins[0] == 0)) return amount/coins[0];
            return (int)Math.pow(10,9);
        }

        int notPick = 0 + coinChangeUtil(idx-1, coins, amount);        
        int pick = 0;
        if(coins[idx]<=amount)
            pick = 1 + coinChangeUtil(idx, coins, amount - coins[idx]);
        else
            pick = (int)Math.pow(10,9);

        
        return Math.min(pick , notPick);
    }
}

// Memoization
//TC: O(N*AMOUNT)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return coinChangeUtil(coins.length-1, coins, amount, dp);
    }
    
    private int coinChangeUtil(int idx, int[] coins, int amount, int[][] dp){
        if(idx==0) {
            if((amount % coins[0] == 0)) return amount/coins[0];
            return (int)Math.pow(10,9);
        }
        
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int notPick = 0 + coinChangeUtil(idx-1, coins, amount, dp);        
        int pick = 0;
        if(coins[idx]<=amount)
            pick = 1 + coinChangeUtil(idx, coins, amount - coins[idx], dp);
        else
            pick = (int)Math.pow(10,9);

        
        return dp[idx][amount] = Math.min(pick , notPick);
    }
}
