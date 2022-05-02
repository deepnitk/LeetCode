//Recursive Solution
//TC: O(2^N)

class Solution {
    public int lengthOfLIS(int[] nums) {
        return lengthofLISUtils(0, -1, nums);
    }
    
    public int lengthofLISUtils(int idx, int prevIdx, int[] nums) {
        //Base Case
        if (idx == nums.length) {
            return 0;
        }
        
        int pick = 0;
        int notPick = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + lengthofLISUtils(idx+1, idx, nums);
        }
        notPick = 0 + lengthofLISUtils(idx+1, prevIdx, nums);
  
        int LISlen = Math.max(pick, notPick);
        return LISlen;
    }
}

//Memoization solution
//TC:O(N^2)
//SC:O(N^2) + ASA
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        
        for(int[] row:dp) {
            Arrays.fill(row, -1);
        }
        return lengthofLISUtils(0, -1, nums, dp);
    }
    
    public int lengthofLISUtils(int idx, int prevIdx, int[] nums, int[][] dp) {
        //Base Case
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][prevIdx+1] != -1) {
            return dp[idx][prevIdx+1];
        }
        int pick = 0;
        int notPick = 0;
        if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + lengthofLISUtils(idx+1, idx, nums, dp);
        }
        notPick = 0 + lengthofLISUtils(idx+1, prevIdx, nums, dp);
  
        dp[idx][prevIdx+1] = Math.max(pick, notPick);
        return dp[idx][prevIdx+1];
    }
}
