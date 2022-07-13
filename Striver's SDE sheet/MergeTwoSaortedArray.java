/*
Gap Algo
TC: O(logn) * o(n) ~ o(nlogn)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = m;i < m + n;i++){
            nums1[i] = nums2[i - m];
        }
        int gap = (int)Math.ceil(( m + n)/2);
        while (gap >= 1) {
            int j = gap;
            int i = 0;
            while (j < m + n) {
                if (nums1[i] > nums1[j]) {
                    swap(nums1, i, j);
                }
                i++;
                j++;
            }
             if (gap == 1) {
                gap = 0;
             } 
            else {
                gap =(int) Math.ceil((double) gap / 2.0);
            }
        }
    }
    
    private void swap(int[] nums, int i , int j) {
        int temp =  nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
