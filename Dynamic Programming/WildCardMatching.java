//Recursive Solution
//TC:O(2^N) Exponential
//SC:O(Exponential)
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        return isMatchUtil(n-1,m-1, s, p);
    }
    
    private boolean isMatchUtil(int i, int j, String s1, String s2){
         if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }
        if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?') 
            return isMatchUtil(i-1,j-1,s1,s2);
        if(s2.charAt(i)=='*')
            return isMatchUtil(i,j-1,s1,s2) || isMatchUtil(i-1,j,s1,s2);
        return false;
    }
}
//Memoization solution
//TC:O(N*M)
//SC:O(N*M) + O(N+M)
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return isMatchUtil(n-1,m-1, s, p, dp);
    }
    
    private boolean isMatchUtil(int i, int j, String s1, String s2, Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(s2.charAt(k) != '*') return false;
            }
            return true;
        }
        
        if(dp[i][j] != null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='?') 
            return dp[i][j] = isMatchUtil(i-1,j-1,s1,s2, dp);
        if(s2.charAt(j)=='*')
            return dp[i][j] = isMatchUtil(i,j-1,s1,s2, dp) || isMatchUtil(i-1,j,s1,s2, dp);
        return dp[i][j] = false;
    }
}
