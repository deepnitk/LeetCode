//DP 
//TC:O(N2)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<n;i++){
            for(int j = 0;j<i;j++){
                if ((i-j) <= nums[j]){
                    dp[i] = Math.min(dp[i], 1+dp[j]);
                }
            }
        }
        return dp[n-1];

    }
}
