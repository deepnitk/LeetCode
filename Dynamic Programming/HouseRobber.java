//Memoization
//TC: O(N)
// SC: O(N)+O(N)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //step 1: Declare dp and pass
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n-1, nums, dp);
    }
    
    private int helper(int idx, int[] nums, int[] dp){
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        // step 2: check base cond.
        if(dp[idx] != -1) return dp[idx];
        int pick = nums[idx] + helper(idx-2, nums, dp);
        int notPick = 0 + helper(idx-1,nums, dp);
        //step 3: Return dp[idx]
        return dp[idx] = Math.max(pick, notPick);
    }
}

//Tabulization
//TC:O(N) SC:O(N)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //step 1: Declare dp and pass
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(n, nums, dp);
    }
    
    private int helper(int n, int[] nums, int[] dp){
        dp[0] = nums[0];
        int neg = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1)
                pick+=dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }
}


