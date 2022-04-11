//Tabulation Solution


class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        String t = s;
        String ss=new StringBuilder(s).reverse().toString();
        return n - longestCommonSubsequenceUtil(ss,t);
    }
    
    private int longestCommonSubsequenceUtil(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
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
                //character match
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) 
                    dp[idx1][idx2] = 1 + dp[idx1-1][idx2-1];

                //character mismatch
                else
                    dp[idx1][idx2] = 0 + Math.max(dp[idx1-1][idx2], dp[idx1][idx2-1]);
            }
        }
        return dp[n][m];  
    }
}
