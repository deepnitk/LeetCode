//Recursive Solution
class Solution {
    public int numSquares(int n) {
        return solve(n);
    }
    int solve(int n) {
        if (n <= 3) {
            return n;
        }
        int ans = n;
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + solve(n - i*i));
        }
        return ans;
    }
}

//Memoization solution
//tc: o(n*sqrt(n))
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }
    int solve(int n, int[] dp) {
        if (n <= 3) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = n;
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + solve(n - i*i, dp));
        }
        return dp[n] = ans;
    }
}
