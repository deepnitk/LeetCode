class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        
        int totalSum = 0;
        for(int a:nums)
            totalSum += a;
        
        int k = totalSum;
        
        boolean[][] dp = new boolean[n][k + 1];
        for(boolean[] row:dp)
            Arrays.fill(row, false);

        //Base cases
        for(int i=0; i<n;i++) dp[i][0] = true;

        if(nums[0]<=k) dp[0][nums[0]] = true;

        for(int idx = 1;idx<n;idx++){
            for(int target = 1; target<=k;target++){

                boolean notPick = dp[idx-1][target];
                boolean pick = false;
                if(target>=nums[idx])
                    pick = dp[idx-1][target-nums[idx]];

                dp[idx][target] = (pick || notPick);                
            }
        }
        
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<=totalSum/2;i++){
            if(dp[n-1][i] == true){
                int s1 = i;
                int s2 = totalSum - i;
                mini = Math.min(mini, Math.abs(s1 - s2));
            }
        }
        
        return mini;
    }
}
