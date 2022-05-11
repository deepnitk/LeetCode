//Binary Search Solution
//TC: O(NLOGN)
//SC: O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        
        for(int i=1;i<n;i++) {
            if (temp.get(temp.size()-1) < nums[i]) {
               temp.add(nums[i]); 
            }
            else {
                temp.set(binarySearch(temp, -1, temp.size() - 1, nums[i]), nums[i]);
            }
        }
        
        return temp.size();
    }
    
    static int binarySearch(ArrayList<Integer> A, int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A.get(m) >= key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
}
