//Recursive solution
//TC: Exponential
//SC: asa
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		HashSet<String> hs = new HashSet<>(wordDict);
		return wordBreakUtils(0, n, s, hs);
	}
	
	public boolean wordBreakUtils(int pos, int n, String s, HashSet<String> hs) {
        if (pos == n) {
            return true;
        }
        for(int i = pos+1; i <= n;i++) {
            if(hs.contains(s.substring(pos, i)) && wordBreakUtils(i, n, s, hs)) {
                return true;
            }
        }
        return false;
    }
}

//Memoization solution
//TC:o(n^2* m)
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		HashSet<String> hs = new HashSet<>(wordDict);
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
			return wordBreakUtils(0, n, s, hs, dp);
		}

	public boolean wordBreakUtils(int pos, int n, String s, HashSet<String> hs, int[] dp) {
		if (pos == n) {
		    return true;
		}
		if (dp[pos] != -1) {
		    return dp[pos] == 1? true: false;
		}
		for(int i = pos+1; i <= n;i++) {
		    if(hs.contains(s.substring(pos, i)) && wordBreakUtils(i, n, s, hs, dp)) {
			dp[pos] = 1;
			return true;
		    }
		}
		dp[pos] = 0;
		return false;
    	}
}


//DP solution
//TC: o(n^2*m)
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		HashSet<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i = n-1;i >= 0;i--){
            for(String w: wordDict) {
                if((i + w.length() <= s.length()) &&  w.equals(s.substring(i, i + w.length()))) {
                    dp[i] = dp[i + w.length()];
                }
                if(dp[i]) {
                    break;
                }
            }
        }
		return dp[0];
	}
}

