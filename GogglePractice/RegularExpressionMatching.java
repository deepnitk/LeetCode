class Solution {
	public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
		
        for(int idx1 = n; idx1>=0; idx1--) {
            for(int idx2 = m; idx2 >=0; idx2--) {
                if (idx1 >= s.length() && idx2 >= p.length()) {
                    dp[idx1][idx2] = true;
                }
                else if (idx2 >= p.length()) {
                    dp[idx1][idx2] = false;
                }
                //star case
                else if (!hasStar(p, idx2)) {
                    dp[idx1][idx2] = isMatching(s,p,idx1, idx2) && dp[idx1 + 1][idx2 + 1];
                }

                else { 
                    dp[idx1][idx2] = dp[idx1][idx2+2]  // don't use *
                        || (isMatching(s,p,idx1, idx2) && dp[idx1+1][idx2]); //use * atleast once
                }
            }
        }
        
        return dp[0][0];
    }
    
    public boolean isMatching(String s, String p, int i, int j) {
        return i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

    }
    
    public boolean hasStar(String p, int idx2) {
        return idx2 + 1 < p.length() && p.charAt(idx2 + 1) == '*';
    }
}
            
