class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (nums == null || n<=1) {
            return;
        }
        int i = n - 2;
        // check from end to identify the dip point..
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        //check for smallest number which is greater than dip element
        if (i >= 0) {
            int j = n - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //Reverse the array from dip element onwards
        reverse(nums, i+1, n - 1);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j) {
       while (i < j) {
           swap(nums, i++, j--);
       }
    }
}
