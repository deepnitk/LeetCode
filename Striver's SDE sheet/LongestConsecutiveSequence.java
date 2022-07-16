//Optimal SOlution
//TC: O(N)
//SC: O(N)
class Solution {
	public int longestConsecutive(int[] nums) {
		int longest = 0;
        HashSet<Integer> hs = new HashSet();
        for(int el: nums) {
            hs.add(el);
        }
        
        for(int i = 0;i < nums.length;i++) {
            if (!hs.contains(nums[i] - 1)) {
                int currLen = 0;
                int currNum = nums[i];
                while ( hs.contains(currNum)) {
                    currLen += 1;
                    currNum++;
                }
                longest = Math.max(longest, currLen);
            }
        }
        return longest;
    }                     
}
