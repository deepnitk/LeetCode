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
        if (idx == n) {
            res.add(new ArrayList<>(subSet));
            return;
        }
        
        //pick 
        subSet.add(nums[idx]);
        subSetsUtils(idx + 1, n, nums, subSet, res);
        subSet.remove(subSet.size() - 1);
        //NotPick
        subSetsUtils(idx + 1, n, nums, subSet, res);
    }


}
