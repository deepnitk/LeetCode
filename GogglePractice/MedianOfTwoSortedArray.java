
//Brute force approach
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean oddLen = false;
        if((m+n)%2 != 0){
            oddLen = true;
        }
        
        ArrayList<Integer> res = new ArrayList<>(m+n);
        int i = 0, j=0;
        while(i<m && j<n) {
            if(nums1[i]<=nums2[j]){
                res.add(nums1[i]);
                i++;
            }
            else {
                res.add(nums2[j]);
                j++;
            }
        }
        while(i<m){
            res.add(nums1[i]);
                i++;
        }
        
        while(j<n) {
            res.add(nums2[j]);
                j++;
        }
        if(oddLen) {
            return (double) res.get((m+n)/2);
        }
        else{
            int x = res.get((m+n)/2);
            int y = res.get(((m+n)/2)+1);
            return (double)((x+y)/2);
        }
    }
}
