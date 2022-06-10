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
