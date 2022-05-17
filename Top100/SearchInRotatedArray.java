class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length -1;
        

        
        //pivot is poiniting to smallest index...
        int pivot = findPivot(nums, left, right, target);
        left = 0;
        right = nums.length - 1;
        
        //we are deciding on which half og=f the arrray target can reside ...
        if(target >= nums[pivot] && target <= nums[right]){
            left = pivot;
        }
        else {
            right = pivot;
        }
        
        return binarySearch(nums, left, right, target);
    }
    
    public int binarySearch(int[] nums, int left, int right, int target){
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;

    }
    
    public int findPivot(int[] nums, int left, int right, int taget) {
        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        } 
        return left;
    }
}
