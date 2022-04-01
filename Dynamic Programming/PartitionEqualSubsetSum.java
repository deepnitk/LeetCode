//Recursive solution
//TC: O(2^N)
//SC: O(2^N) + O(K)

class Solution {
    public boolean canPartition(int[] nums) {
        int k = 0;
        for(int a:nums)
            k+=a;
        return canPartitionUtil(nums.length-1, k/2, nums);
    }
    
    private boolean canPartitionUtil(int idx, int k, int[] nums){
        if(k==0) return true;
        if(idx == 0){
            if(nums[0]== k) return true;
            else return false;
        }
        
        boolean notPick = canPartitionUtil(idx-1, k, nums);
        boolean pick = false;
        if(k>=nums[idx])
            pick = canPartitionUtil(idx-1, k-nums[idx], nums);
        
        return (pick || notPick);
    }
}

//Memoization solution

class Solution {
    public boolean canPartition(int[] nums) {
        int k = 0;
        for(int a:nums)
            k+=a;
        boolean[][] dp = new boolean[nums.length][k/2 +1];
        for(boolean[] row:dp)
            Arrays.fill(row, false);
        if(k%2 != 0) return false;
        return canPartitionUtil(nums.length-1, k/2, nums, dp);
    }
    
    private boolean canPartitionUtil(int idx, int k, int[] nums, boolean[][] dp){
        if(k==0) return true;
        if(idx == 0){
            if(nums[0]== k) return true;
            else return false;
        }
        if(dp[idx][k] != false) return dp[idx][k];
        
        boolean notPick = canPartitionUtil(idx-1, k, nums, dp);
        boolean pick = false;
        if(k>=nums[idx])
            pick = canPartitionUtil(idx-1, k-nums[idx], nums, dp);
        
        return dp[idx][k] = (pick || notPick);
    }
}

//Tabulation solution

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        return canPartitionUtil(n, nums);
    }
    
    private boolean canPartitionUtil(int n, int[] nums){
        
        int totalSum = 0;
        for(int a:nums)
            totalSum+=a;

        if(totalSum%2 == 1) return false;
        
        else{
            int k = totalSum/2;
            boolean[][] dp = new boolean[n][k + 1];
            for(boolean[] row:dp)
                Arrays.fill(row, false);

            //Base cases
            for(int i=0; i<n;i++)
                dp[i][0] = true;

            if(nums[0]<=k)
                dp[0][nums[0]] = true;

            for(int idx = 1;idx<n;idx++){
                for(int target = 1; target<=k;target++){

                    boolean notPick = dp[idx-1][target];
                    boolean pick = false;
                    if(target>=nums[idx])
                        pick = dp[idx-1][target-nums[idx]];

                    dp[idx][target] = (pick || notPick);                
                }
            }

            return dp[n-1][k];
        }

    }
}
