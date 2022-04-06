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

//Tabulation solution
//TC: O(N*T)
//SC: O(N*T)
class Solution {
    public int change(int amount, int[] coins) {

        
        return changeUtils(coins, amount);
    }
    
    private int changeUtils(int[] coins, int amount){
        
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        
        for(int idx=1;idx<n;idx++){
            for(int amt=0;amt<=amount;amt++){
                    int notPick = dp[idx-1][amt];
                    int pick = 0;
                    if(coins[idx]<=amt) pick += dp[idx][amt-coins[idx]];

                    dp[idx][amt] = pick+notPick;
            }
        }
        
        return dp[n-1][amount];
    }
}
