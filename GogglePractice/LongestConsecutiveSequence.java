//TC: O(N)
//SC: O(1)
class Solution {
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> hs = new HashSet<>();
        //Base case
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        //Add every element to hashset
		for(int num : nums) {
			hs.add( num);
		}
		int maxLen = 1;
        //Iterate again. if (nums[i] - 1) exists continue, elif (nums[i] + 1) increase maxLen by 1 until u get it.
		for(int i =0; i < nums.length; i++) {
			if (!hs.contains(nums[i] - 1)) {
				int  k = 1;
				int len = 1;
                while (hs.contains(nums[i] + k)) {
                    len++;
                    k++;
                }
                maxLen = Math.max(len, maxLen);
			}
	    }
	    return maxLen;
    }
}
