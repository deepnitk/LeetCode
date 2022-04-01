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
