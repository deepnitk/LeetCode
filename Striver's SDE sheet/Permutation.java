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

//Optimal using swapping in place
//tc: o(n!*n)
//sc:o(1)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUtils(0, nums, res);
        return res;
    }
    
    private void permuteUtils(int idx, int[] nums, List<List<Integer>> res) {
        if (idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int el : nums) {
                ds.add(el);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = idx; i < nums.length;i++) {
            swap(nums, i, idx);
            permuteUtils(idx + 1, nums, res);
            swap(nums, i, idx);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
