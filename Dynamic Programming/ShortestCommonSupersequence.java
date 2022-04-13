class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return shortestCommonSupersequenceUtil(str1, str2);
    }
    
    private String shortestCommonSupersequenceUtil(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        
        //Base cases
        for(int i=0;i<=n;i++)
            dp[i][0] = 0;
        for(int j=0;j<=m;j++)
            dp[0][j] =0;
        
        for(int idx1 =1; idx1<=n;idx1++){
            for(int idx2 =1; idx2<=m; idx2++){
                
                if(s1.charAt(idx1-1) == s2.charAt(idx2-1))
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];
                else
                    dp[idx1][idx2] = Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }
        
        int i=n, j=m;
        String res = "";
        while(i>0 && j>0){
            if(s1.charAt(i-1)== s2.charAt(j-1)){
                res += s1.charAt(i-1);
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                res += s1.charAt(i-1);
                i--;
            } else {
                res += s2.charAt(j-1);
                j--;
            }    
        }
        
        while(i>0){
            res += s1.charAt(i-1);
            i--;
        }
        
        while(j>0){
            res += s2.charAt(j-1);
            j--;
        }
        
        String ans = new StringBuilder(res).reverse().toString();
        return ans;
    }
}
