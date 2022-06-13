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
// Bit Manipulation Approach
// TC: O(2^n * n)
// SC : O(1)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		subSetsUtils(0, n, nums, new ArrayList<>(), res);
		return res;
    }
    
    private static void subSetsUtils(int idx, int n, int[] nums, List<Integer> subSet, List<List<Integer>> res) {
        if ( idx == n ) {
            res.add(new ArrayList<>(subSet));
            return;
        }

        //Pick case
        subSet.add(nums[idx]);
        subSetsUtils(idx + 1, n, nums, subSet, res);
        subSet.remove(subSet.size() - 1);

        //Not pick case
        subSetsUtils(idx + 1, n, nums, subSet, res);
    }

}
