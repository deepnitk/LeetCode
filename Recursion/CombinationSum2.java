class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        combinationSum2Utils(0, n, candidates, target, res, new ArrayList<>());
        return new ArrayList<>(res);
    }
    
    private void combinationSum2Utils(int idx, int n , int[] candidates, int target, List<List<Integer>> res, List<Integer> curr) {
        if ( target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i< n; i++) {
            if (i > idx && candidates[i] == candidates[i-1]) {
                continue;
            }
            if ( candidates[i] > target ) {
                break;
            }
            curr.add(candidates[i]);
            combinationSum2Utils(i + 1, n, candidates, target - candidates[i], res, curr);
            curr.remove(curr.size() - 1);
        }
    }
    
}
