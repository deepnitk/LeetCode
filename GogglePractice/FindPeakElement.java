//Binary search method
//TC: O(log n)
class Solution {
	public int findPeakElement(int[] nums) {
        int n = nums.length;
        //edge case: single element
        if (n == 1) {
            return 0;
        }
        int lo = 0;
        int hi = n - 1;
        while ( lo <= hi ) {
            int mid = lo + (hi - lo)/2;
            //range is from 1 to n-2 (inclusive)
            if(mid > 0 && mid < n -1) {
                if ( nums[mid -1] < nums[mid]  && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                else if ( nums[mid] < nums[mid + 1]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            // when mid == 0 (edge case)
            else if (mid == 0) {
                if(nums[0] > nums[1]) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
            //when mid == n-1 (edge case)
            else {
                if (nums[n - 1] > nums[n -2]) {
                    return n - 1;
                }
                else {
                    return n - 2;
                }
            }
        }
        return -1;
    }
}
