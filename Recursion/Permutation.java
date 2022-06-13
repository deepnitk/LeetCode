class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        permuteUtils(n, nums, res, new ArrayList<>());
        return res;
    }
    
    private void permuteUtils(int n, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if( curr.size() == n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!curr.contains(nums[i])) {
                curr.add(nums[i]);
                permuteUtils(n, nums, res, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
