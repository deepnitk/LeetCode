//Brute -- using XOR concept x ^ x = ?

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int el : nums) {
            ans = ans ^ el;
        }
        
        return ans;
    }
}

//Binary search
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == nums[mid^1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
