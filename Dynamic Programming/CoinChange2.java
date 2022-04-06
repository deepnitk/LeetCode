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
