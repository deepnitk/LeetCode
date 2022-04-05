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
        int ans = coinChangeUtil(coins.length-1, coins, amount, dp);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
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

//Tablulation Approach
// TC: O(N*T)
// SC : O(N*T)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeUtil(coins, amount);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
    
    private int coinChangeUtil(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        
        // for(int i =0;i<=amount;i++){
        //     if((amount % coins[0] == 0)) dp[0][i] = amount/coins[0];
        // }
        
        for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0)  
                dp[0][i] = i/coins[0];
            else dp[0][i] = (int)Math.pow(10,9);
    }
        
        for(int idx = 1; idx<n;idx++){
            for(int amt =0;amt<=amount;amt++){
                int notPick = 0 + dp[idx-1][amt];        
                int pick = 0;
                if(coins[idx]<=amt)
                    pick = 1 + dp[idx][amt - coins[idx]];
                else
                    pick = (int)Math.pow(10,9);

                dp[idx][amt] = Math.min(pick , notPick);
            }
        }
        return dp[n-1][amount];
    }
        
}

//Space Optimization
// TC: O(N*AMOUNT)
// SC: O(AMOUNT)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = coinChangeUtil(coins, amount);
        if(ans >= (int)Math.pow(10,9)) return -1;
        return ans;
    }
    
    private int coinChangeUtil(int[] coins, int amount){
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        Arrays.fill(prev, 0);
        Arrays.fill(curr, 0);
        
        // for(int i =0;i<=amount;i++){
        //     if((amount % coins[0] == 0)) dp[0][i] = amount/coins[0];
        // }
        
        for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0)  
                prev[i] = i/coins[0];
            else prev[i] = (int)Math.pow(10,9);
    }
        
        for(int idx = 1; idx<n;idx++){
            for(int amt =0;amt<=amount;amt++){
                int notPick = 0 + prev[amt];        
                int pick = 0;
                if(coins[idx]<=amt)
                    pick = 1 + curr[amt - coins[idx]];
                else
                    pick = (int)Math.pow(10,9);

                curr[amt] = Math.min(pick , notPick);
            }
            prev = curr;
        }
        return prev[amount];
    }
        
}
