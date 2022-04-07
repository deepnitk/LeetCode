//Recursive Solution
//TC: O(2^N+S^M)

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return longestCommonSubsequenceUtil(n-1, m-1, text1, text2);
    }
    
    private int longestCommonSubsequenceUtil(int idx1, int idx2, String text1, String text2){
        //Base case
        if(idx1<0 || idx2<0) return 0;
        
        //character match
        if(text1.charAt(idx1) == text2.charAt(idx2)) return 1 + longestCommonSubsequenceUtil(idx1-1, idx2-1, text1, text2);
        
        //character mismatch
        return 0 + Math.max(longestCommonSubsequenceUtil(idx1-1, idx2, text1,text2), 
                            longestCommonSubsequenceUtil(idx1, idx2-1, text1,text2));
    }
}

//Memoization
//TC:O(N*M)
//OC: ASS
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp)
            Arrays.fill(row, -1);
        return longestCommonSubsequenceUtil(n-1, m-1, text1, text2, dp);
    }
    
    private int longestCommonSubsequenceUtil(int idx1, int idx2, String text1, String text2, int[][] dp){
        //Base case
        if(idx1<0 || idx2<0) return 0;
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        //character match
        if(text1.charAt(idx1) == text2.charAt(idx2)) 
            return dp[idx1][idx2] = 1 + longestCommonSubsequenceUtil(idx1-1, idx2-1, text1, text2, dp);
        
        //character mismatch
        return dp[idx1][idx2] = 0 + Math.max(longestCommonSubsequenceUtil(idx1-1, idx2, text1,text2, dp), 
                            longestCommonSubsequenceUtil(idx1, idx2-1, text1,text2, dp));
    }
}

//Tabulation approach
//TC:O(N*M)
//SC:O(N*M)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        return longestCommonSubsequenceUtil(text1, text2);
    }
    
    private int longestCommonSubsequenceUtil(String text1, String text2){
        int n = text1.length();
        int m = text2.length();
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

//Space optimization
//TC:O(N*M)
//SC:O(M)
int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        // Base Case is covered as we have initialized the prev and cur to 0.
        
        for(int idx1= 1;idx1<=n;idx1++){
            for(int idx2=1;idx2<=m;idx2++){
                //character match
                if(text1.charAt(idx1-1) == text2.charAt(idx2-1)) 
                    curr[idx2] = 1 + prev[idx2-1];

                //character mismatch
                else
                    curr[idx2] = 0 + Math.max(prev[idx2], curr[idx2-1]);
            }
            prev = curr;
        }
        return prev[m];
