//Two Pointer approach

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n<=1) return;
        int left = 0;
        int right = 0;
        while(right<n){
            if(nums[right]==0)
                right++;
            else{
                swap(left, right, nums);
                left++;
                right++;
            }
        }
    }
    void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
