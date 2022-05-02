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
