// Bit Manipulation Approach
// TC: O(2^n * n)
// SC : O(1)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < (1<<n); i++) {
            ArrayList<Integer> subSet = new ArrayList<>();
            for( int j = 0; j < n; j++) {
                //check if jth bit is set or not
                if ((i & (1 << j)) != 0) {
                    subSet.add(nums[j]);
                }
            }
            res.add(subSet);
        }
        
        return res;
    }
}

//Recursive solution

// Bit Manipulation Approach
// TC: O(2^n * n)
// SC : O(1)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int k = 0; k <= n; k++) {
            backTrack(0, k, n, nums, new ArrayList<>(), res);
        }
        return res;
    }
    
    private void backTrack( int idx, int k, int n, int[] nums, ArrayList<Integer> curr, List<List<Integer>> res) {
        if ( k == curr.size() ) {
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = idx; i < n; i++) {
            curr.add(nums[i]);
            backTrack(i + 1, k, n, nums, curr, res);
            curr.remove(curr.size() - 1);
        }
        
    }
}
