
/*
It would be much easier to understand if different permutation are considered same. For example (123) (132) (231) (213) (312) (321) are different permutation of (123). In this question they are considered different. Trivial Pick-NonPick technique will not work here as suppose we have 123 and we are at 2(index 1). Here we have option to include this or exclude and move foreward. But..we have one more option of moving backward.
Thus if we have no restriction on number of elements or order, we can use simple for loop. For every element we pick, we will pick next element which can be anyone from start to end. And thus for loop runs from 0 to last index everytime. Base case is simple. If we ever come to a state where target is 0, it means the set of numbers we picked sums up to t hance we have atleast 1 answer. Thus we return 1. After the recursive code is written, memoization is pretty simple.
*/

class Solution {
    public int combinationSum4(int[] candidates, int target) {
        int n = candidates.length;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSum4Utils(n, candidates, target, dp);
    }
    
    private int combinationSum4Utils(int n, int[] candidates, int target, int[] dp) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count  = 0;
        for ( int i = 0;i < n; i++) {
            if (candidates[i] <= target) {
                count += combinationSum4Utils(n, candidates, target - candidates[i], dp);
            }
        }
        return dp[target] = count;
    }
}
