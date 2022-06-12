class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3Utils(1, k, n, res, new ArrayList<>());
        return new ArrayList<>(res);
    }
    private void combinationSum3Utils(int idx, int n, int target, List<List<Integer>> res, List<Integer> curr) {
        if ( target == 0 && curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i<= 9; i++) {
            if ( i > target ) {
                break;
            }
            curr.add(i);
            combinationSum3Utils(i + 1, n, target - i, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
