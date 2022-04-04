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
