//Tabulation Approach | LIS
//TC:O(N2)
// SC:O(N)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        //For Storing LDS
        int[] hash = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
        }
        
        int maxLen = 0;
        int lastIndex =0;
        for(int idx = 0; idx<n;idx++) {
            for(int prev_idx = 0; prev_idx<idx; prev_idx++){
                if (nums[idx] % nums[prev_idx] == 0 && 1+dp[prev_idx] > dp[idx]) {
                    dp[idx] = 1+dp[prev_idx];
                    hash[idx] = prev_idx;
                }
            }
            if(dp[idx] > maxLen){
                maxLen = dp[idx];
                lastIndex = idx;
            }
        }
        
        // Store LDS
        List<Integer> lds = new ArrayList<>();
        lds.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lds.add(nums[lastIndex]);
        }
        Collections.reverse(lds);

        return lds;        
    }
}
