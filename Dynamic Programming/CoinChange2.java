// Recursive solution
// TC: o(2^n)
// sc: o(2^n) + ASS
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return changeUtils(n-1, coins, amount);
    }
    
    private int changeUtils(int idx, int[] coins, int amount){
        if(idx == 0){
            if(amount%coins[0] == 0 ) return 1;
            else return 0;
        }
        
        int notPick = changeUtils(idx-1, coins, amount);
        int pick = 0;
        if(coins[idx]<=amount) pick += changeUtils(idx, coins, amount-coins[idx]);
        
        return pick+notPick;
    }
}

//Memoization solution
//TC: O(N*T)
//SC: O(N*T) + ASS
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        
        return changeUtils(n-1, coins, amount, dp);
    }
    
    private int changeUtils(int idx, int[] coins, int amount, int[][] dp){
        if(idx == 0){
            if(amount%coins[0] == 0 ) return 1;
            else return 0;
        }
        
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        int notPick = changeUtils(idx-1, coins, amount, dp);
        int pick = 0;
        if(coins[idx]<=amount) pick += changeUtils(idx, coins, amount-coins[idx], dp);
        
        return dp[idx][amount] = pick+notPick;
    }
}
