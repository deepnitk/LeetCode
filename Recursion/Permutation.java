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

//Solution with extra space 
//TC: O(N! * N)
//SC: O(N) + O(N) (MAP)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        permuteUtils(nums, res, ds, freq);
        return res;
    }
    
    private void permuteUtils(int[] nums, List<List<Integer>> res, List<Integer> ds, boolean[] freq) {
        if ( ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] != true) {
                freq[i] = true;
                ds.add(nums[i]);
                permuteUtils(nums, res, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}

//Better approach
//TC: O(N! * N)
//sc: ASA


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUtils(0, nums, res);
        return res;
    }
    
    private void permuteUtils(int idx, int[] nums, List<List<Integer>> res) {
        if ( idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int el: nums) {
                ds.add(el);
            }
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            permuteUtils(idx+1, nums, res);
            swap(i, idx, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
