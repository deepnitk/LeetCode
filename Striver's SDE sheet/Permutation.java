//Brute approach
//tc: o(n!*n)
//sc:o(n) + o(n)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permuteUtils(ds, nums, res, freq);
        return res;
    }
    
    private void permuteUtils(List<Integer> ds, int[] nums, List<List<Integer>> res, boolean[] freq) {
        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length;i++) {
            if ( !freq[i] ) {
                freq[i] = true;
                ds.add(nums[i]);
                permuteUtils(ds, nums, res, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}
