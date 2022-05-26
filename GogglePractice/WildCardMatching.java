//Recursive solution
//TC: EXPONENTIAL
class Solution {
    public boolean isMatch(String s, String p) {
        int n  = s.length();
        int m = p.length();
        return isMatchUtil(s, p, n - 1, m - 1);
    }
    public boolean isMatchUtil(String s, String p, int i, int j) {
		if(i < 0 && j < 0) return true;
		if(i >= 0 && j < 0) return false;
		if(i < 0 && j >=0) {
			for(int k = 0; k<=j; k++) {
				if (p.charAt(k) != '*') {
					return false;
				}
			}
			return true;
		}
		
		if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			return isMatchUtil(s, p, i - 1, j - 1);
		}
		if(p.charAt(j) == '*') {
			return isMatchUtil(s, p, i, j - 1) || isMatchUtil(s, p, i - 1, j);
		}
		return false;
	}
}

//Memoization
//TC: O(N*M)
//SC: O(N*M) + ASS
class Solution {
    public boolean isMatch(String s, String p) {
        int n  = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return isMatchUtil(s, p, n - 1, m - 1, dp);
    }
    public boolean isMatchUtil(String s, String p, int i, int j, Boolean[][] dp) {
		if(i < 0 && j < 0) return true;
		if(i >= 0 && j < 0) return false;
		if(i < 0 && j >=0) {
			for(int k = 0; k<=j; k++) {
				if (p.charAt(k) != '*') {
					return false;
				}
			}
			return true;
		}
        
		if (dp[i][j] != null) {
            return dp[i][j];
        }
		if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
			return dp[i][j] = isMatchUtil(s, p, i - 1, j - 1, dp);
		}
		if (p.charAt(j) == '*') {
			return dp[i][j] = isMatchUtil(s, p, i, j - 1, dp) || isMatchUtil(s, p, i - 1, j, dp);
		}
		return dp[i][j] = false;
	}
}
