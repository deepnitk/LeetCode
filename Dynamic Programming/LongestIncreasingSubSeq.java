//Memoization solution
//TC:O(N2)
//SC:O(N2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return lengthOfLISUtils(nums, 0, -1, dp);
    }
    
    public int lengthOfLISUtils(int[] nums, int idx, int prev_idx, int[][] dp) {
        
        if (idx == nums.length) {
            return 0;
        }
        if (dp[idx][prev_idx+1] != -1) {
           return  dp[idx][prev_idx+1];
        }
        int len = 0 + lengthOfLISUtils(nums, idx+1, prev_idx, dp);
        
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
            len = Math.max(len, 1 +lengthOfLISUtils(nums, idx+1, idx, dp));
        }
        
        return dp[idx][prev_idx+1] = len;
        
    }
}

//Tabulation 

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int[] row:dp){
            Arrays.fill(row, 0);
        }
        
        for(int idx = n-1;idx>=0;idx--) {
            for(int prev_idx = idx-1;prev_idx>=-1;prev_idx--){
                int len = 0 + dp[idx+1][prev_idx + 1];
        
                if(prev_idx == -1 || nums[idx] > nums[prev_idx]) {
                    len = Math.max(len, 1 +dp[idx+1][idx+1]);
                }
                dp[idx][prev_idx+1] = len;
            }
        }
        return dp[0][-1+1];
    }
}


//Tabulation solution
//TC:O(N^2)
//SC:O(N)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        
        for(int idx = 0; idx<n;idx++) {
            for(int prev_idx = 0; prev_idx<idx; prev_idx++){
                if (nums[prev_idx] < nums[idx]) {
                   dp[idx] = Math.max(1+dp[prev_idx], dp[idx]);
                }
            }
        }
        int maxLen = 0;
        for(int el:dp){
            maxLen = Math.max(maxLen, el);
        }
        return maxLen;
    }
}

//Store and print LIS
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        //For Printing LIS
        int[] hash = new int[n];
        for(int i=0;i<n;i++){
            hash[i] = i;
        }
        int maxLen = 0;
        int lastIndex =0;
        for(int idx = 0; idx<n;idx++) {
            for(int prev_idx = 0; prev_idx<idx; prev_idx++){
                if (nums[prev_idx] < nums[idx] && 1+dp[prev_idx] > dp[idx]) {
                    dp[idx] = 1+dp[prev_idx];
                    hash[idx] = prev_idx;
                }
            }
            if(dp[idx] > maxLen){
                maxLen = dp[idx];
                lastIndex = idx;
            }
        }
        
//         Store LIS
//         ArrayList<Integer> lis = new ArrayList<>();
//         lis.add(nums[lastIndex]);
        
//         while(hash[lastIndex] != lastIndex) {
//             lastIndex = hash[lastIndex];
//             lis.add(nums[lastIndex]);
//         }
//         Collections.reverse(lis);

        return maxLen;
    }
}
