//Recursive solution

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int s = 0;
        int n = nums.length;
        for(int num:nums)
            totalSum+=num;
        
        //Checking for edge cases
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        
        s = (totalSum-target)/2;
        
        return findTargetSumWaysUtils(n-1, nums, s);
    }
    
    private int findTargetSumWaysUtils(int idx, int[] nums, int s){
        //Base cases
        if(idx == 0){
            if(s==0 && nums[0]==0)
                return 2;
            if(s==0 || s == nums[0])
                return 1;
            return 0;
        }
        
        int notPick = findTargetSumWaysUtils(idx-1, nums, s);
        int pick = 0;
        if(nums[idx]<=s)
            pick += findTargetSumWaysUtils(idx-1, nums, s-nums[idx]);
        
        return pick + notPick;
    }
    
}

//Memoization
// TC: O(N*SUM)
// SC: O(N*SUM) + O(N)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int s = 0;
        int n = nums.length;
        for(int num:nums)
            totalSum+=num;
        
        //Checking for edge cases
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        
        s = (totalSum-target)/2;
        
        int[][] dp = new int[n][s+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        
        return findTargetSumWaysUtils(n-1, nums, s, dp);
    }
    
    private int findTargetSumWaysUtils(int idx, int[] nums, int s, int[][] dp){
        //Base cases
        if(idx == 0){
            if(s==0 && nums[0]==0)
                return 2;
            if(s==0 || s == nums[0])
                return 1;
            return 0;
        }
        if(dp[idx][s] != -1) return dp[idx][s];
        int notPick = findTargetSumWaysUtils(idx-1, nums, s, dp);
        int pick = 0;
        if(nums[idx]<=s)
            pick += findTargetSumWaysUtils(idx-1, nums, s-nums[idx], dp);
        
        return dp[idx][s] = pick + notPick;
    }
    
}

//Tabulation solution
//TC: O(N*K)
// SC: O(N*K)

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int s = 0;
        
        for(int num:nums)
            totalSum+=num;
        
        //Checking for edge cases
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        
        s = (totalSum-target)/2;

        return findTargetSumWaysUtils(nums, s);
    }
    
    private int findTargetSumWaysUtils(int[] nums, int s){
        
        int n = nums.length;
        int[][] dp = new int[n][s+1];
        for(int[] row:dp)
            Arrays.fill(row, 0);
        
        //Base cases        
        for(int sum=0;sum<=s;sum++){
            if(sum==0 && nums[sum] == 0) dp[0][sum] = 2;
            else if(sum==0 || sum == nums[0]) dp[0][sum]=1;
            else dp[0][sum] = 0;
        }
        
        for(int idx =1;idx<n;idx++){
            for(int sum =0; sum<=s;sum++){
                int notPick = dp[idx-1][sum];
                int pick = 0;
                if(nums[idx]<=sum)
                    pick += dp[idx-1][sum-nums[idx]];

                dp[idx][sum] = pick + notPick;                
            }
        }
        
        return dp[n-1][s];
    }
    
}

//Space Optimization

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int s = 0;
        
        for(int num:nums)
            totalSum+=num;
        
        //Checking for edge cases
        if(totalSum-target<0) return 0;
        if((totalSum-target)%2==1) return 0;
        
        s = (totalSum-target)/2;

        return findTargetSumWaysUtils(nums, s);
    }
    
    private int findTargetSumWaysUtils(int[] nums, int s){
        
        int n = nums.length;
        int[] prev = new int[s+1];

        //Base cases        
        for(int sum=0;sum<=s;sum++){
            if(sum==0 && nums[sum] == 0) prev[sum] = 2;
            else if(sum==0 || sum == nums[0]) prev[sum]=1;
            else prev[sum] = 0;
        }
        
        for(int idx =1;idx<n;idx++){
            int[] curr = new int[s+1];
            for(int sum =0; sum<=s;sum++){
                int notPick = prev[sum];
                int pick = 0;
                if(nums[idx]<=sum)
                    pick += prev[sum-nums[idx]];

                curr[sum] = pick + notPick;                
            }
            prev = curr;
        }
        
        return prev[s];
    }
    
}
