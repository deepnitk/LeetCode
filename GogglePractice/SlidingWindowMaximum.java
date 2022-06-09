//Brute Force
//TC(N*K)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int r = 0;
        for(int i =  0; i< (n - k + 1); i++) {
            int maxi = nums[i];
            for (int j = i; j <= (i + k -1); j++) {
                maxi = Math.max(maxi, nums[j]);
            }
            res[r] = maxi;
            r++;
        }
        return res;
    }
}
