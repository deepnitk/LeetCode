//Tabulation solution
//TC: O(N*M)
//SC: O(N*M)

//lONGEST COMMON SUBARRAY/SUBSTRING
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //Index shifting to accomodate base case...
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp)
            Arrays.fill(row, -1);

        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }
        
        for(int idx1= 1;idx1<=n;idx1++){
            for(int idx2=1;idx2<=m;idx2++){
                //number match
                if(nums1[idx1-1] == nums2[idx2-1]) 
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];

                //number mismatch
                else
                    dp[idx1][idx2] = 0;
            }
        }
        
        int ans = Integer.MIN_VALUE;
        //Finding max value in dp[][]
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans;
        
        
    }
}
