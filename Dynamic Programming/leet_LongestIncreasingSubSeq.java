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

//Tabulation
//TC:O(N2)
//SC:O(N2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row:dp) {
            Arrays.fill(row, 0);
        }
        
        for (int idx = n-1;idx>=0;idx--) {
            for(int prevIdx = idx-1; prevIdx>=-1;prevIdx--) {
                int pick = 0;
                int notPick = 0;
                if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    //co-ordinate shift hence 2nd paramaeter+1
                    pick = 1 + dp[idx+1][idx+1];
                }
                //co-ordinate shift hence 2nd paramaeter+1
                notPick = 0 + dp[idx+1][prevIdx+1];

                dp[idx][prevIdx+1] = Math.max(pick, notPick);                    
            }
        }
        
        return dp[0][-1+1];
    }
}

//Space Optimization
//TC:O(N2)
//SC:O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] nextRow = new int[n+1];
        Arrays.fill(nextRow, 0);
        int[] prevRow = new int[n+1];
        Arrays.fill(prevRow, 0);        
        
        for (int idx = n-1;idx>=0;idx--) {
            for(int prevIdx = idx-1; prevIdx>=-1;prevIdx--) {
                int pick = 0;
                int notPick = 0;
                if (prevIdx == -1 || nums[idx] > nums[prevIdx]) {
                    //co-ordinate shift hence 2nd paramaeter+1
                    pick = 1 + nextRow[idx+1];
                }
                //co-ordinate shift hence 2nd paramaeter+1
                notPick = 0 + nextRow[prevIdx+1];

                prevRow[prevIdx+1] = Math.max(pick, notPick);                    
            }
            nextRow = prevRow;
        }
        
        return nextRow[-1+1];
    }
}

//Best Optimised
//TC:O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        
        for(int idx=0;idx<n;idx++){
            for(int prev=0;prev<idx;prev++){
                if (nums[prev]<nums[idx]) {
                   dp[idx] = Math.max(1 + dp[prev], dp[idx]); 
                }
            }
        }
        
        int maxi =0;
        for(int i=0;i<dp.length;i++) {
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
