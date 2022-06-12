//TC: O( 2^T * N)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        combinationSumUtils(0, n, candidates, target, res, new ArrayList<>());
        return res;
    }
    
    private void combinationSumUtils(int idx, int n , int[] candidates, int target, List<List<Integer>> res, List<Integer> curr) {
        if (idx == n){
            if ( target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;

        }
        
        //Pick
        if ( candidates[idx] <= target) {
            curr.add(candidates[idx]);
            combinationSumUtils(idx, n, candidates, target - candidates[idx], res, curr);
            curr.remove(curr.size() - 1);
        }

        
        //Non Pick
        combinationSumUtils(idx + 1, n, candidates, target, res, curr);
        
    }
}
