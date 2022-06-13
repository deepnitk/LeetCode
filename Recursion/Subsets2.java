class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        subsetsWithDupUtils(0, n, nums, res, new ArrayList<>());
        return res;
    }
    
    private void subsetsWithDupUtils(int idx, int n, int[] nums, List<List<Integer>> res, List<Integer> curr) {
        res.add(new ArrayList<>(curr));        
        for(int i = idx; i < n; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            
            curr.add(nums[i]);
            subsetsWithDupUtils(i + 1, n, nums, res, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
