class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //step 1: Declare dp and pass
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        
        if(n==1) return helper(n, nums, dp);
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        int l=0, m=0;
        for(int i=0;i<n;i++){
            if(i!=0) temp2[l++]=nums[i];
            if(i != n-1) temp1[m++]=nums[i];
        }
        int takeFirst = helper(n-1, temp1, dp);
        int takeLast = helper(n-1, temp2, dp);
        return Math.max(takeFirst, takeLast);
    }
    
    private int helper(int n, int[] nums, int[] dp){
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1)
                pick+=prev2;
            int notPick = 0 + prev;
            int curri = Math.max(pick, notPick);
            prev2=prev;
            prev=curri;
        }
        return prev;
    }
}
