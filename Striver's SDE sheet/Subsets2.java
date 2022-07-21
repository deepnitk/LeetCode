class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupUtils(0,nums, res, new ArrayList());
        return res;
    }
    
    private void subsetsWithDupUtils(int idx, int[] nums, List<List<Integer>> res, List<Integer> ds) {
        res.add(new ArrayList<>(ds));
        for(int i = idx;i < nums.length; i++) {
            if (i != idx && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            subsetsWithDupUtils(i + 1, nums, res, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
