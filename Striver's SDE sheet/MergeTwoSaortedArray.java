/*
Better Approach
we can think of Iterating in arr1 and whenever we encounter an element that is greater than the first element of arr2, just swap it. 
Now rearrange the arr2 in a sorted manner, after completion of the loop we will get elements of both the arrays in non-decreasing order
TC: O(n*m)
SC: O(1)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0)
        {
            for(int i = 0; i < m; i++) {
                //compare every element of nums1 with nums2[0]
                if (nums1[i] > nums2[0]) {
                    int temp =  nums1[i];
                    nums1[i] = nums2[0];
                    nums2[0] = temp;
                }

                //Rearrange nums2
                int first = nums2[0];
                int k;
                // insertion sort is used here
                for (k = 1; k < n && nums2[k] < first; k++) {
                  nums2[k - 1] = nums2[k];
                }
                nums2[k - 1] = first;
            }
            for(int i = m;i < m + n;i++){
                nums1[i] = nums2[i - m];
            }            
        }

    }
    
}

/*
Optimal : Gap Algo
TC: O(logn) * o(n) ~ o(nlogn)
SC: O(1)
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
