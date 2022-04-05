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
